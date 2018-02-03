package morke.scroller.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Config {

	/**
	 * Lee el fichero de configuración y devuelve un mapa con sus valores
	 * 
	 * @param path
	 *            Ruta del archivo
	 * @param separator
	 *            Carácter separador del archivo Clave ; Valor
	 * @return Map<String,String> Mapa con los valores del fichero
	 */
	public static Map<String, String> ReadConfig(String path, String separator) {
		Map<String, String> values = new HashMap<>();
		BufferedReader br = null;
		String line = "";
		try {
			br = new BufferedReader(new FileReader(path));
			while ((line = br.readLine()) != null) {
				String[] splits = line.split(separator);
				values.put(splits[0], splits[1]);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Archivo no encontrado");
		} catch (IOException e) {
			System.err.println("No se ha podido abrir el archivo. " + e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.err.println("No se ha podido cerrar el archivo. " + e.getMessage());
				}
			}
		}
		return values;
	}

	/**
	 * Escribe el par Clave ; Valor en el fichero de configuración y devuelve un boolean segun su exito
	 * @param path Ruta del archivo
	 * @param separator Carácter separador del archivo Clave ; Valor
	 * @param Key Clave a cambiar
	 * @param Value Valor a añadir
	 * @return true si consigue guardar cambios en cualquier otro caso false
	 */
	public static boolean WriteConfig(String path, String separator, String Key, String Value) {
		boolean changed = false;
		Map<String, String> values = ReadConfig(path, separator);
		values.replace(Key, Value);
		FileWriter fileWriter=null;
		try {
			fileWriter = new FileWriter(path);
		} catch (IOException e1) {	
			System.err.println("Error al abrir el archivo. " + e1.getMessage());
		}

		for (Entry<String, String> entry : values.entrySet()) {
			try {
				fileWriter.write(entry.getKey() + separator + entry.getValue());
			} catch (IOException e) {
				System.err.println("Error al escribir." +e.getMessage());
			} finally {
				try {
					fileWriter.flush();
					fileWriter.close();
					changed=true;
				} catch (IOException e) {
					System.err.println("Error al cerrar o vaciar fileWriter. "+e.getMessage());
				}

			}
		}

		return changed;
	}
}
