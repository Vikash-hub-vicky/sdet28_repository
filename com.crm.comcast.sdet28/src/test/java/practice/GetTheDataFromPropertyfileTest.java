package practice;

import java.io.FileInputStream;

import java.util.Properties;

class GetTheDataFromPropertyfileTest {

	public static void main(String[] args) throws Throwable {
		
		//java object representation of physical propertyfile
		
		FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
		// create an object for properties file
		Properties property = new Properties();
		//load the key and values from properties keys 
		property.load(fis);
		//fetch the value using respective keys
		String browser = property.getProperty("browser");
		String url = property.getProperty("url");
		String username = property.getProperty("username");
		String password = property.getProperty("password");
		
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		
	}

}
