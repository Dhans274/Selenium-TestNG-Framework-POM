package Assign_Framework.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class utility
{
	static Properties propertyTable;
	static FileInputStream inputStream;
	
	public static Properties loadConfigVariables(String propertypath) throws IOException {
		try{
			inputStream=new FileInputStream(propertypath);
			propertyTable= new Properties();
			propertyTable.load(inputStream);
			return propertyTable; // returns all key and values from EnvVaibles
					
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			inputStream.close();
		}
		return propertyTable;
	}
	
	
}