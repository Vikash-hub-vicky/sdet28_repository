package com.crm.comcast.sdet28.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * Utility for property file
 * @author VIKASH PRATAP SINGH
 *
 */

public class FileUtility {
	/**
	 * this method will fecth the data from property file based on the key passed
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyFileData(String key) throws Throwable {
		FileInputStream file = new FileInputStream(IPathConstants.PROPERTY_FILEPATH);
		Properties property = new Properties();
		property.load(file);
		return property.getProperty(key);
		

}
}
