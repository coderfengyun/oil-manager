package org.oil.manager.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigParser {

	private final Properties properties;

	public ConfigParser(String propertiesFilePath)
			throws FileNotFoundException, IOException {
		properties = new Properties();
		properties.load(new FileInputStream(propertiesFilePath));
	}

	public Properties getProperties() {
		return properties;
	}

}
