package morke.scroller.loaders;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class VertexLoader {
	public static int vao;
	public static VertexBufferObject vbos;
	
	private static final float[] vertexs = {
			-1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f
	};
	
	private static final int[] indices = {
			0, 1, 2, 0, 2, 3
	};
	
	private static final float[] uvs = {
			0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1
	};
	
	public static void loadObject()
	{
		vao = GL30.glGenVertexArrays();
		GL30.glBindVertexArray(vao);
	
		vbos = new VertexBufferObject();
		
		vbos.vertex = GL15.glGenBuffers();
		vbos.index = GL15.glGenBuffers();
		vbos.texture = GL15.glGenBuffers();
		
		loadVbo(vbos.vertex, vertexs, 0);
		loadVbo(vbos.texture, uvs, 1);
		loadVbo(vbos.index, indices);
	}
	
	private static void loadVbo(int vbo, float[] data, int attribute)
	{
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, FloatBuffer.wrap(data), GL15.GL_STATIC_DRAW);

		GL20.glEnableVertexAttribArray(attribute);
		GL20.glVertexAttribPointer(attribute, 2, GL11.GL_FLOAT, false, 0, 0);
		
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
	}
	
	private static void loadVbo(int vbo, int[] data)
	{
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, vbo);
		GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, IntBuffer.wrap(data), GL15.GL_STATIC_DRAW);
		GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
	}
}
