package morke.scroller.display;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.lwjgl.glfw.GLFW;

import morke.scroller.Vars;
import morke.scroller.utils.Config;

public class Display {
	private long window;
	
	public Display()
	{
		int width = Config.GetValueInt("width");
		int height = Config.GetValueInt("height");
		String title = Vars.NAME;
		
		Path path = Paths.get("libs/lwjgl/");
	    String librarypath = path.toAbsolutePath().toString();

	    System.setProperty("org.lwjgl.librarypath", librarypath);
		
	    if(!GLFW.glfwInit())
	    {
	    	System.err.println("Error initializating GLFW.");
	    }
	    
		GLFW.glfwDefaultWindowHints();
		window = GLFW.glfwCreateWindow(width, height, title, 0, 0);
		if(window == 0)
		{
			System.err.println("GLFW: error creating the window.");
			return;
		}
		
		GLFW.glfwSetKeyCallback(window, (wnd, key, scancode, action, mods) -> {
			
		});
		
		GLFW.glfwMakeContextCurrent(window);
		
		GLFW.glfwSwapInterval(1);
		
		GLFW.glfwShowWindow(window);
	}
	
	@Override
	public void finalize()
	{
		GLFW.glfwDestroyWindow(window);
	}
	
	public boolean shouldWindowClose()
	{
		return GLFW.glfwWindowShouldClose(window);
	}
	
	public void eventHandler()
	{
		GLFW.glfwPollEvents();
	}
	
	public void swapBuffers()
	{
		GLFW.glfwSwapBuffers(window);
	}
}
