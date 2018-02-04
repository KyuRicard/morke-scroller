package morke.scroller.display;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.lwjgl.glfw.GLFW.*;

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
		
	    if(!glfwInit())
	    {
	    	System.err.println("Error initializating GLFW.");
	    }
	    
		glfwDefaultWindowHints();
		window = glfwCreateWindow(width, height, title, 0, 0);
		if(window == 0)
		{
			System.err.println("GLFW: error creating the window.");
			return;
		}
		
		glfwSetKeyCallback(window, (wnd, key, scancode, action, mods) -> {
			
		});
		
		glfwSetWindowSizeCallback(window, (wnd, w, h) -> {
			Config.WriteConfig("width", Integer.toString(w));
			Config.WriteConfig("height", Integer.toString(h));
		});
		
		
		glfwMakeContextCurrent(window);
		
		glfwSwapInterval(1);
		
		glfwShowWindow(window);
	}
	
	@Override
	public void finalize()
	{
		glfwDestroyWindow(window);
	}
	
	public boolean shouldWindowClose()
	{
		return glfwWindowShouldClose(window);
	}
	
	public void eventHandler()
	{
		glfwPollEvents();
	}
	
	public void swapBuffers()
	{
		glfwSwapBuffers(window);
	}
}
