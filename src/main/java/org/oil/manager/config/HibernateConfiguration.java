package org.oil.manager.config;

import java.util.Properties;

public class HibernateConfiguration {
	private final String driver_class;
	private final String url;
	private final String userName;

	public HibernateConfiguration(Properties properties) {
		this.driver_class = properties
				.getProperty("hibernate.connection.driver_class");
		this.url = properties.getProperty("hibernate.connection.url");
		this.userName = properties.getProperty("hibernate.connection.username");
	}

	public String getDriver_class() {
		return driver_class;
	}

	public String getUrl() {
		return url;
	}

	public String getUserName() {
		return userName;
	}

}
