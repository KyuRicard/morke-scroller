package morke.scroller.maths;

public class Vector2i {
	public int x, y;
	
	public Vector2i()
	{
		x = y = 0;
	}
	
	public Vector2i(int r, float theta)
	{
		this.x = (int) (Math.sin(theta) * r);
		this.y = (int) (Math.cos(theta) * r);
	}
	
	public Vector2i(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public static Vector2i add(Vector2i v1, Vector2i v2)
	{
		return new Vector2i(v1.x + v2.x, v1.y + v2.y);
	}
	
	public static Vector2i negate(Vector2i v)
	{
		return new Vector2i(-v.x, -v.y);
	}
	
	public static Vector2i sub(Vector2i v1, Vector2i v2)
	{
		return Vector2i.add(v1, Vector2i.negate(v2));
	}
	
	public static Vector2i mult(Vector2i v, int x)
	{
		return new Vector2i(v.x * x, v.y * x);
	}
	
	public static Vector2i div(Vector2i v, int x)
	{
		return new Vector2i(v.x / x, v.y / x);
	}
	
	public static int cross(Vector2i v1, Vector2i v2)
	{
		return v1.x * v2.y - v1.y * v2.x;
	}
}
