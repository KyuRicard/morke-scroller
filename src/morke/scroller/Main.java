package morke.scroller;

import morke.scroller.display.Display;

public class Main {

	public static void main(String[] args) {
		// Load configuration
		
		// Create display
		Display disp = new Display("Test", 1280, 720);	
		
		while(!disp.shouldWindowClose())
		{
			// Pull events
			disp.eventHandler();
			
			// Update
			
			// Render
			
			// Render present
			disp.swapBuffers();
		}
	}

}
