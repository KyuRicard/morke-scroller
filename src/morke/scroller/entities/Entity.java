package morke.scroller.entities;

import glm.mat._4.Mat4;
import glm.vec._2.Vec2;
import morke.scroller.loaders.ImgLoader;
import morke.scroller.sprite.Sprite;

public class Entity {
	Vec2 position;
	Sprite sprite;
	
	public Entity()
	{
		position = new Vec2(0, 0);
	}
	
	public void setSprite(String filename)
	{
		sprite = new Sprite(filename);
		ImgLoader.loadImage(sprite);
	}
	
	public Sprite getSprite()
	{
		return sprite;
	}
	
	public void move(int dx, int dy) {
		position.add(dx, dy);
	}
	
	public void setPosition(int dx, int dy) {
		position.set(dx, dy);
	}
	
	public Vec2 getPosition()
	{
		return position;
	}
	
	public Mat4 createModelMatrix()
	{
		Mat4 mat = new Mat4();
		mat.translate(position.x, position.y, 0);
		mat.scale(sprite.getSize().x, sprite.getSize().y, 0);
		return mat;
	}
}	
