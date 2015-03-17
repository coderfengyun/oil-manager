package org.oil.manager.helper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;

@Component
public final class SessionHelper {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionHelper() {
		try {
			Configuration cfg = new Configuration()
					.configure("hibernate.cfg.xml");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(cfg.getProperties()).build();
			this.setSessionFactory(cfg.buildSessionFactory(serviceRegistry));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Session openSession() {
		try {
			return this.getSessionFactory().openSession();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
