package morke.scroller.engine;

import morke.scroller.utils.Utils;

public class Shader {
	int programID;
	int vertexShader, fragmentShader;
	
	final String vertexExt = ".vs", fragmentExt = ".fs";
	
	public Shader(String shader)
	{
		String vertexSrc = Utils.readFile(shader + vertexExt);
		String fragmentSrc = Utils.readFile(shader + fragmentExt);
	}
}
