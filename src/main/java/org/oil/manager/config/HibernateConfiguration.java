package org.oil.manager.config;

import java.util.Properties;

public class HibernateConfiguration {
	private static final String[] propertyNames = new String[] {
			"hibernate.connection.username", "hibernate.connection.url",
			"hibernate.connection.driver_class",
			"hibernate.connection.password", "hibernate.connection.pool.size",
			"hibernate.connection.pool.size", "hibernate.show_sql",
			"format_sql", "Connection.useUnicode",
			"connection.characterEncoding", "hibernate.dialect",
			"hibernate.hbm2ddl.auto", "connection.autoReconnect",
			"connection.autoReconnectForPools",
			"connection.is-connection-validation-required" };
	private final Properties properties;

	private HibernateConfiguration(Properties wholeProperties) {
		this.properties = new Properties();
		for (String name : propertyNames) {
			this.properties.put(name, wholeProperties.get(name));
		}
	}

	public Properties getOwnProperties() {
		return properties;
	}

	public static HibernateConfiguration config(Properties properties) {
		return new HibernateConfiguration(properties);
	}
}
