package entities;

import sprite.Sprite;
import java.awt.Image;
//import java.awt.event.KeyEvent;
//import javax.swing.ImageIcon;

public class Entities {
	
	private int x;
	private int y;
	private Image imagen;
	private Sprite sprite;
	
	public Entities(){
		sprite.creaImagen();
	}
	
	public void mover(int dx, int dy) {
		x+=dx;
		y+=dy;
	}
	
	public void set(int dx, int dy) {
		x=dx;
		y=dy;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Image getImagen() {
		return imagen;

	}
}
