package org.oil.manager.config;

import java.io.IOException;
import java.util.Properties;

/**
 * Here you must add the config file's parent folder to the classpath. And the
 * config file's name must be "config.properties"
 * 
 * @author chentienan
 *
 */
public class ConfigParser {
	private static final String propertiesFilePath = "config.properties";
	private final Properties properties;

	private ConfigParser(String propertiesFilePath) throws IOException {
		properties = new Properties();
		properties.load(ConfigParser.class.getClassLoader()
				.getResourceAsStream(propertiesFilePath));
	}

	public Properties getProperties() {
		return properties;
	}

	/**
	 * Here you must add the config file's parent folder to the classpath. And
	 * the config file's name must be "config.properties"
	 * 
	 * 
	 * @return
	 * @throws IOException
	 */
	public static ConfigParser build() throws IOException {
		return build(propertiesFilePath);
	}

	public static ConfigParser build(String propertiesFilePath)
			throws IOException {
		return new ConfigParser(propertiesFilePath);
	}

}
