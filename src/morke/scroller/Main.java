package morke.scroller;

import java.io.IOException;

import morke.scroller.display.Display;
import morke.scroller.utils.Config;

public class Main {

	public static void main(String[] args) throws IOException {
		// Load configuration
		Config.ReadConfig("config.ini");		
			
		// Create display
		Display disp = new Display();	
		
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
