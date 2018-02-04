package morke.scroller.utils;

import java.util.function.BooleanSupplier;

public class TripleBoolean extends Number implements BooleanSupplier {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int value;

	protected TripleBoolean(int val)
	{
		value = val;
	}
	
	public static TripleBoolean True = new TripleBoolean(1), False = new TripleBoolean(0), Undefined = new TripleBoolean(-1);

	@Override
	public int intValue() {
		return value;
	}

	@Override
	public long longValue() {
		return value;
	}

	@Override
	public float floatValue() {
		return value;
	}

	@Override
	public double doubleValue() {
		return value;
	}

	@Override
	public boolean getAsBoolean() {
		return value == 1;
	}
	
	public static TripleBoolean fromBool(boolean b)
	{
		return b ? True : False;
	}
	
	public static TripleBoolean fromInteger(int i)
	{
		return i != 0 ? True : False;
	}

	public void toggle() {
		value = value == 0 ? 1 : 0;
	}
}

