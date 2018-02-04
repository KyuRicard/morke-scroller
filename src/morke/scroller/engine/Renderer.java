package morke.scroller.engine;

import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;

import org.lwjgl.opengl.GL30;

import morke.scroller.entities.Entity;
import morke.scroller.loaders.VertexLoader;
import morke.scroller.sprite.Sprite;

public class Renderer {
	private static Renderer instance;
	
	ArrayList<Entity> renderQueue;
	
	private Renderer()
	{
		renderQueue = new ArrayList<>();
	}
		
	public static Renderer getInstance()
	{
		if(instance == null)
		{
			instance = new Renderer();
		}
		return instance;
	}
	
	public void addToRenderQueue(Entity entity)
	{
		renderQueue.add(entity);
	}
	
	public void render()
	{
		GL30.glBindVertexArray(VertexLoader.vao);
		// Render sprites
		
		for(Entity e : renderQueue)
		{
			
		}
		GL30.glBindVertexArray(0);
		// Clear queue
		emptyQueue();
	}
	
	private void emptyQueue()
	{
		renderQueue.clear();
	}

}
