package morke.scroller.input;

import static org.lwjgl.glfw.GLFW.*;

public class Key {
	public KeyState state;
	public char charValue;
	public int scancode;
	public int mods;
	public int key;
	
	public void processCharValue()
	{
		charValue = (char)key;
		if((mods & GLFW_MOD_SHIFT) != 1)
		{
			charValue = Character.toLowerCase(charValue);
		}
	}
}
