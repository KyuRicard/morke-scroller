package morke.scroller.gamestate;

import org.lwjgl.glfw.GLFW;

import morke.scroller.Vars;
import morke.scroller.entities.Entity;
import morke.scroller.input.Input;

public class MenuState extends GameState {

	@Override
	public void onCreate() {
		Entity e = new Entity();
		e.setSprite("_default.png");
		e.move(100, 100);
		entities.add(e);
	}

	@Override
	public void onUpdate() {
		if(Input.getInstance().singleRelease(GLFW.GLFW_KEY_ESCAPE))
		{
			Vars.running = false;
		}
	}
	
	@Override
	public void onInit() {
		System.out.println("Initialization of MenuState");
	}
}
