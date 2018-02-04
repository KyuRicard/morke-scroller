package morke.scroller.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Config {

	private static final String delimiter = "=";
	public static Map<String, String> config;

	/**
	 * Lee el fichero de configuración y devuelve un mapa con sus valores
	 * 
	 * @param path
	 *            Ruta del archivo
	 * @return Map<String,String> Mapa con los valores del fichero
	 * @throws IOException 
	 */
	public static Map<String, String> ReadConfig(String path) throws IOException {
		File f = new File(path);
		
		if (!Files.exists(f.toPath())) {
			CreateDefaultConfig(path);
		}
		
		config = new HashMap<>();
		
		List<String> lines = Files.readAllLines(f.toPath());
		
		for(String line : lines)
		{
			if(line.isEmpty() || line.startsWith(";")) continue;
			String[] formated = line.split(delimiter);
			config.put(formated[0], formated[1]);
		}
		
		return config;
	}

	/**
	 * Escribe el par Clave ; Valor en el fichero de configuración y devuelve un
	 * boolean segun su exito
	 * 
	 * @param key
	 *            Clave a cambiar
	 * @param value
	 *            Valor a añadir
	 * @return true si consigue guardar cambios en cualquier otro caso false
	 */
	public static boolean WriteConfig(String key, String value) {
		boolean changed = false;
		if(config.containsKey(key))
			config.replace(key, value);
		else config.put(key, value);
		
		return changed;
	}
	
	public static boolean WriteConfig(String key, int intValue)
	{
		return WriteConfig(key, Integer.toString(intValue));
	}
	
	public static boolean WriteConfig(String key, boolean boolValue)
	{
		return WriteConfig(key, boolValue ? 1 : 0);
	}
	
	public static boolean SaveConfig(String path)
	{
		try {
			PrintWriter writer = new PrintWriter(path);
			for (Entry<String, String> entry : config.entrySet()) {
				writer.println(entry.getKey() + delimiter + entry.getValue());
			}
			writer.close();
			return true;
		} catch (IOException e) {
			System.err.println("Error al escribir." + e.getMessage());
			return false;
		}
	}

	public static void CreateDefaultConfig(String path) {
		System.err.println("Generando archivo por defecto ...");
		try {
			PrintWriter writer = new PrintWriter(path);
			writer.println("width" + delimiter + "640");
			writer.println("height" + delimiter + "480");
			writer.println("fov" + delimiter + "60");
			writer.println("distance" + delimiter + "1000");
			writer.println("fullscreen" + delimiter + "0");
			writer.println("windowed" + delimiter + "0");
			writer.close();
		} catch (IOException e1) {
			System.err.println("Error al crear el archivo. " + e1.getMessage());
		}
	}
	
	public static String GetValue(String key)
	{
		if(config.containsKey(key))
			return config.get(key);
		else
			return "-1";
	}
	
	public static int GetValueInt(String key)
	{
		return Integer.parseInt(GetValue(key));
	}
}
