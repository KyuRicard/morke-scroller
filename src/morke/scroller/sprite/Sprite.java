package morke.scroller.sprite;

import java.awt.Image;
//import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


public class Sprite {

	private int x;
	private int y;
	private Image imagen;
	
	public Sprite() {
		creaImagen();
	}
	
	public void creaImagen() {
		ImageIcon ii = new ImageIcon("crear.png");
		imagen = ii.getImage();
		x = 0;
		y = 0;
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
	
	/*public void teclaPulsada(KeyEvent e) {
		int key=e.getKeyCode();
		
		if(key==KeyEvent.VK_LEFT) {
			dx=-1;
		}
		if(key==KeyEvent.VK_RIGHT) {
			dx=-1;
		}
		if(key==KeyEvent.VK_UP) {
			dy=-1;
		}
		if(key==KeyEvent.VK_DOWN) {
			dy=-1;
		}
	}
	
	public void teclaSoltada(KeyEvent e) {
		int key=e.getKeyCode();
		
		if(key==KeyEvent.VK_LEFT) {
			dx=0;
		}
		if(key==KeyEvent.VK_RIGHT) {
			dx=0;
		}
		if(key==KeyEvent.VK_UP) {
			dy=0;
		}
		if(key==KeyEvent.VK_DOWN) {
			dy=0;
		}
	}*/
}
