package morke.scroller.maths;

public class Vector2f {
	public float x, y;
	
	public Vector2f()
	{
		x = y = 0;
	}
	
	public Vector2f(float r, double theta)
	{
		this.x = (float) (Math.sin(theta) * r);
		this.y = (float) (Math.cos(theta) * r);
	}
	
	public Vector2f(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public static Vector2f add(Vector2f v1, Vector2f v2)
	{
		return new Vector2f(v1.x + v2.x, v1.y + v2.y);
	}
	
	public static Vector2f negate(Vector2f v)
	{
		return new Vector2f(-v.x, -v.y);
	}
	
	public static Vector2f sub(Vector2f v1, Vector2f v2)
	{
		return Vector2f.add(v1, Vector2f.negate(v2));
	}
	
	public static Vector2f mult(Vector2f v, float x)
	{
		return new Vector2f(v.x * x, v.y * x);
	}
	
	public static Vector2f div(Vector2f v, float x)
	{
		return new Vector2f(v.x / x, v.y / x);
	}
	
	public static float cross(Vector2f v1, Vector2f v2)
	{
		return v1.x * v2.y - v1.y * v2.x;
	}
}
