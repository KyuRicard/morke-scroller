package morke.scroller.loaders;

import static org.lwjgl.opengl.GL11.*;

import java.nio.ByteBuffer;

import morke.scroller.sprite.Sprite;

public class ImgLoader {
	public static int loadImage(Sprite sprite)
	{
		int texture = glGenTextures();
		glBindTexture(GL_TEXTURE_2D, texture);
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, (int)sprite.getSize().x, (int)sprite.getSize().y, 0, GL_RGBA, GL_BYTE, ByteBuffer.wrap(sprite.getPixels()));
		
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
		
		glBindTexture(GL_TEXTURE_2D, 0);
		
		sprite.textureID = texture;
		
		return texture;
	}
}
