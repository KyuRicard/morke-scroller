package morke.scroller.sprite;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import glm.vec._2.Vec2;
import morke.scroller.utils.Utils;


public class Sprite {

	private Vec2 size;
	private byte[] pixels;
	public int textureID;
	
	public Sprite(String img) {
		try {
			BufferedImage buffImg = ImageIO.read(new File(img));
			size = Utils.pixelsToPercentage(new Vec2(buffImg.getWidth(), buffImg.getHeight()));
			pixels = ((DataBufferByte) buffImg.getRaster().getDataBuffer()).getData();
		} catch(IOException e)
		{
			size = new Vec2(0, 0);
			pixels = new byte[0];
		}
	}
			
	public Vec2 getSize()
	{
		return size;
	}
	
	public byte[] getPixels()
	{
		return pixels;
	}
	
}
