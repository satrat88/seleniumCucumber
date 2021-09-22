package supportLibraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * Singleton Class that loads Property file and can reuse across project 
 * 
 *
 */

public class LoadProperties {
	
	private static Properties properties = getPropFile();
	private LoadProperties()
	{
	//To prevent external instantiation of this class	
	}

	public static Properties getInstance()
	{
		
		return properties;
	}
	
	
	/**
	 * Load Settings.properties file data
	 * @return
	 * @throws IOException
	 */
	
	private static Properties getPropFile()	{
		
		FileInputStream file;
		Properties properties = new Properties();
		try {
			file = new FileInputStream(System.getProperty("user.dir")+"\\Settings.properties");
			properties.load(file);
		} catch (IOException e) {
			System.out.println("Error while loading File"+e.getMessage());
		}
		
		return properties;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		throw new CloneNotSupportedException();
	}
}
