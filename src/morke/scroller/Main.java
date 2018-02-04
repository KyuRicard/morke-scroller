package morke.scroller;

import java.io.IOException;
import java.util.Map.Entry;

import morke.scroller.display.Display;
import morke.scroller.input.Input;
import morke.scroller.input.Key;
import morke.scroller.input.KeyState;
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
			for(Entry<Integer, Key> x : Input.getInstance().getMap().entrySet())
			{
				if(x.getValue().state == KeyState.StatePressed)
				{
					System.out.println(x.getValue().charValue);
				}
			}
			// Render
			
			// Render present
			disp.swapBuffers();
		}
		
		// Save configuration
		Config.SaveConfig("config.ini");
		
		// Delete display
		disp.finalize();
	}

}
