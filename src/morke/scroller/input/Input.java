package morke.scroller.input;

import java.util.HashMap;
import java.util.Map;

public class Input {
	Map<Integer, Key> keymap;
	private static Input instance;
	
	private Input()
	{
		keymap = new HashMap<>();
	}
	
	public static Input getInstance()
	{
		if(instance == null)
		{
			instance = new Input();
		}
		return instance;
	}
	
	public void addKey(int key, int scancode, int action, int mods)
	{
		if(keymap.containsKey(key))
		{
			keymap.get(key).state = KeyState.fromAction(action);
			keymap.get(key).mods = mods;
			keymap.get(key).processCharValue();
		}
		else
		{
			Key k = new Key();
			k.key = key;
			k.scancode = scancode;
			k.mods = mods;
			k.state = KeyState.fromAction(action);
			k.processCharValue();
			keymap.put(key, k);
		}
	}
	
	public KeyState getState(int key)
	{
		return keymap.containsKey(key) ? keymap.get(key).state : KeyState.StateInvalid;
	}
	
	public int getMods(int key)
	{
		return keymap.containsKey(key) ? keymap.get(key).mods : -1;
	}
	
	public int getScancode(int key)
	{
		return keymap.containsKey(key) ? keymap.get(key).scancode : -1;
	}
	
	public char getChar(int key)
	{
		return keymap.containsKey(key) ? keymap.get(key).charValue : '\0';
	}
	
	public Map<Integer, Key> getMap()
	{
		return this.keymap;
	}
}
