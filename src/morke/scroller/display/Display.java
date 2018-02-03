package morke.scroller.display;

import org.lwjgl.glfw.GLFW;

public class Display {
	private String title;
	private int width, height;
	private long window;
	
	public Display(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		
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
}
