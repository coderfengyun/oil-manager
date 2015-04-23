package org.oil.manager.helper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.oil.manager.config.ConfigParser;
import org.oil.manager.config.HibernateConfiguration;
import org.oil.manager.entity.CompositeId;
import org.oil.manager.entity.FluidPhysicalParameter;
import org.oil.manager.entity.IndicatorWeightDistribution;
import org.oil.manager.entity.PreferredPlan;
import org.oil.manager.entity.RodStringDesignParameter;
import org.oil.manager.entity.RodStructureParameter;
import org.oil.manager.entity.WellBaseData;
import org.oil.manager.entity.WellDesignParameter;
import org.oil.manager.entity.WellInflowTrend;
import org.oil.manager.entity.WellPressureDistribution;
import org.oil.manager.entity.WellProductData;
import org.oil.manager.entity.compositeid.EntityWithCompositeId;
import org.oil.manager.jpa.Customer;
import org.oil.manager.jpa.Deal;
import org.springframework.stereotype.Component;

@Component
public final class SessionHelper {
	private SessionFactory sessionFactory;
	private static final Class<?>[] Annotated_Entity_Classes = new Class<?>[] {
			FluidPhysicalParameter.class, CompositeId.class,
			IndicatorWeightDistribution.class, PreferredPlan.class,
			RodStringDesignParameter.class, RodStructureParameter.class,
			EntityWithCompositeId.class, WellBaseData.class,
			WellDesignParameter.class, WellInflowTrend.class,
			WellPressureDistribution.class, WellProductData.class, Deal.class,
			Customer.class };

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionHelper() {
		try {
			Configuration cfg = new Configuration();
			cfg.addProperties(HibernateConfiguration.config(
					ConfigParser.build().getProperties()).getOwnProperties());
			for (Class<?> annotatedClass : Annotated_Entity_Classes) {
				cfg.addAnnotatedClass(annotatedClass);
			}
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(cfg.getProperties()).build();
			this.setSessionFactory(cfg.buildSessionFactory(serviceRegistry));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

}
