package morke.scroller.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;


public class Config {
	
	private String csvFile;
	BufferedReader br = null;
	String line = "";
    String Splitchar = ";";
    Map <String,String> values = null;
	
    public Map<String,String> ReadConfig(String path,String separator)
    {
    	try
        {  		
    		br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
            	String[] splits = line.split(Splitchar);
            	values.put(splits[0], splits[1]);
            }
        }catch (FileNotFoundException e){
        	System.err.println("Archivo no encontrado");
        }
        catch(IOException e)
        {
        	System.err.println("No se ha podido abrir el archivo. "+ e.getMessage());
        }
    	finally{
    		if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                	System.err.println("No se ha podido cerrar el archivo. "+ e.getMessage());
                }
            }
    	}
		return values;
    }
}
