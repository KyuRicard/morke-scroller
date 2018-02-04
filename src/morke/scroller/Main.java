package morke.scroller;

import java.io.IOException;
import morke.scroller.display.Display;
import morke.scroller.gamestate.GameState;
import morke.scroller.gamestate.MenuState;
import morke.scroller.loaders.VertexLoader;
import morke.scroller.utils.Config;

public class Main {
   
	public static void main(String[] args) throws IOException {
		// Load configuration
		Config.ReadConfig("config.ini");		
				
		// Create display
		Display disp = new Display();	
		VertexLoader.loadObject();
		
		// Create GameState
		GameState.changeGameState(new MenuState());

		while(!disp.shouldWindowClose())
		{
			// Clear screen
			disp.clear();
			
			// Pull events
			disp.eventHandler();
			
			// Update
			disp.update();
			GameState.updateGameState();
			
			// Render
			GameState.renderGameState();
			
			// Render present
			disp.swapBuffers();
		}
		
		// Save configuration
		Config.SaveConfig("config.ini");
		
		// Delete display
		disp.finalize();
	}

}
