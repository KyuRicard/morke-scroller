package morke.scroller.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import glm.vec._2.Vec2;

public class Utils {
	public static Vec2 pixelsToPercentage(Vec2 v) {
		return new Vec2(v.x / Config.GetValueInt("width"), v.y / Config.GetValueInt("height"));
	}

	public static String readFile(String file)
	{
		try {
			String str = "";
			List<String> strs = Files.readAllLines(Paths.get(file));
			for(String s : strs)
				str += s + "\n";
			return str;
		}
		catch(IOException e)
		{
			System.err.println("Cannot read " + file + "\n" + e.getMessage());
			return "";
		}
	}
}
