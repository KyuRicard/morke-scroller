package morke.scroller.display;

import static org.lwjgl.glfw.GLFW.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.lwjgl.glfw.GLFW;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.GL;

import morke.scroller.Vars;
import morke.scroller.input.Input;
import morke.scroller.utils.Config;
import morke.scroller.utils.TripleBoolean;

public class Display {
	private long window;
	private TripleBoolean fullscreen, windowed;
	
	public Display()
	{
		int width = Config.GetValueInt("width");
		int height = Config.GetValueInt("height");
		fullscreen = TripleBoolean.fromInteger(Config.GetValueInt("fullscreen"));
		windowed = TripleBoolean.fromInteger(Config.GetValueInt("windowed"));
		String title = Vars.NAME;
		
		Path path = Paths.get("libs/lwjgl/");
	    String librarypath = path.toAbsolutePath().toString();

	    System.setProperty("org.lwjgl.librarypath", librarypath);
		
	    glfwSetErrorCallback((code, errorPtr) -> {
	    	System.err.println("GLFW error: " + code);
	    });
	    
	    if(!glfwInit())
	    {
	    	System.err.println("Error initializating GLFW.");
	    }
	    
	    glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
	    glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 0);
	    glfwWindowHint(GLFW_DECORATED, windowed.getAsBoolean() ? 0 : 1);
	    
		window = glfwCreateWindow(width, height, title, fullscreen.getAsBoolean() ? glfwGetPrimaryMonitor() : 0, 0);
		if(window == 0)
		{
			System.err.println("GLFW: error creating the window.");
			return;
		}
		
		updateCallbacks();
		
		glfwMakeContextCurrent(window);
		
		glfwSwapInterval(1);
		
		glfwShowWindow(window);
		
		GL.createCapabilities();
	}
	
	private void updateCallbacks()
	{
		glfwSetKeyCallback(window, (wnd, key, scancode, action, mods) -> {
			Input.getInstance().addKey(key, scancode, action, mods);
		});
	}
	
	@Override
	public void finalize()
	{
		glfwDestroyWindow(window);
	}
	
	public boolean shouldWindowClose()
	{
		return glfwWindowShouldClose(window) || !Vars.running;
	}
	
	public void eventHandler()
	{
		glfwPollEvents();
	}
	
	public void swapBuffers()
	{
		glfwSwapBuffers(window);
	}
	
	public void clear()
	{
		glClear(GL_COLOR_BUFFER_BIT);
	}
	
	public void update()
	{
		// TODO: delete this
		if(Input.getInstance().singlePress(GLFW_KEY_F11))
		{
			// Toggle fullscreen
			fullscreen.toggle();
			glfwWindowHint(GLFW_DECORATED, windowed.getAsBoolean() ? 0 : 1);
			
			long newWindow = glfwCreateWindow(Config.GetValueInt("width"), Config.GetValueInt("height"), 
					Vars.NAME, fullscreen.getAsBoolean() ? GLFW.glfwGetPrimaryMonitor() : 0, window);
			glfwDestroyWindow(window);
			window = newWindow;
			glfwMakeContextCurrent(window);
			updateCallbacks();
			Config.WriteConfig("fullscreen", fullscreen.intValue());
			Input.getInstance().setChanged(GLFW_KEY_F11, false);
		}
	}
}
