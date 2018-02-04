package morke.scroller.input;

import static org.lwjgl.glfw.GLFW.*;

import morke.scroller.utils.TripleBoolean;

public class Key {
	public KeyState state;
	public char charValue;
	public int scancode;
	public int mods;
	public int key;
	public TripleBoolean changed = TripleBoolean.Undefined;
	
	public void processCharValue()
	{
		charValue = (char)key;
		if((mods & GLFW_MOD_SHIFT) != 1)
		{
			charValue = Character.toLowerCase(charValue);
		}
	}
}
