package morke.scroller.input;

import static org.lwjgl.glfw.GLFW.*;

public enum KeyState {
	StatePressed, StateReleased, StateCount, StateInvalid;
	
	public static KeyState fromAction(int action)
	{
		if(action == GLFW_PRESS) return KeyState.StatePressed;
		else if (action == GLFW_RELEASE) return KeyState.StateReleased;
		else return KeyState.StateInvalid;
	}
}
