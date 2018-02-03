package morke.scroller.entities;

public class Camera {
	
	private int x,y; 
	private float near_plane;
	private float far_plane;
	private float FOV;
	
	public Camera(int x, int y, float near_plane, float far_plane, float fov) {
		this.x = x;
		this.y = y;
		this.near_plane = near_plane;
		this.far_plane = far_plane;
		this.FOV = fov;
	}
}
