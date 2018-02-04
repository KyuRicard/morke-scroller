package morke.scroller.gamestate;

import java.util.ArrayList;
import java.util.List;

import morke.scroller.engine.Renderer;
import morke.scroller.entities.Entity;

public abstract class GameState {
	List<Entity> entities;
	
	public GameState()
	{
		entities = new ArrayList<>();
		onInit();
	}
	
	public abstract void onCreate();
	public abstract void onUpdate();
	public void onClose() {}
	public void onInit() {}
	public void onFixedUpdate() {}
	
	private static GameState currentGameState;
	public static void changeGameState(GameState gs)
	{
		if(currentGameState != null) currentGameState.onClose();
		gs.onCreate();
		currentGameState = gs;
	}
	
	public static void updateGameState()
	{
		if(currentGameState != null) currentGameState.onUpdate();
	}
	
	public static void renderGameState()
	{
		if(currentGameState != null)
		{
			currentGameState.entities.forEach((e) -> Renderer.getInstance().addToRenderQueue(e));
			Renderer.getInstance().render();
		}
	}
}
