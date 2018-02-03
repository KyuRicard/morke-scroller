package morke.scroller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import morke.scroller.display.Display;
import morke.scroller.utils.Config;

public class Main {

	public static void main(String[] args) {
		// Load configuration
		Path path = Paths.get("src/");
		Map<String,String> valores = Config.ReadConfig(path.toAbsolutePath().toString()+"\\Config.ini", "=");
		
		Config.WriteConfig(path.toAbsolutePath().toString()+"\\Config.ini", "=", "windowed", "RICHARD_HDP");
		
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
