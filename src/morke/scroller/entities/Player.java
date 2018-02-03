package morke.scroller.entities;

import java.awt.Image;
//import java.awt.event.KeyEvent;
//import javax.swing.ImageIcon;

import morke.scroller.sprite.Sprite;

public class Player {
	
	private int x;
	private int y;
	private Image imagen;
	private Sprite sprite;
	
	public Player(){
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
