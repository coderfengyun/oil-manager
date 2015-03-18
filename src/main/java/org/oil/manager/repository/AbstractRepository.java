package org.oil.manager.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.oil.manager.entity.Aggregate;
import org.oil.manager.helper.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractRepository<Entity> {
	private SessionHelper sessionHelper;
	private Logger logger = Logger.getLogger(this.getClass());

	SessionHelper getSessionHelper() {
		return sessionHelper;
	}

	@Autowired
	void setSessionHelper(SessionHelper sessionHelper) {
		this.sessionHelper = sessionHelper;
	}

	void releaseSession(Session session) {
		if (session != null) {
			session.close();
		}
	}

	Logger getLogger() {
		return this.logger;
	}

	protected boolean attachCore(Aggregate dumEntity) {
		Session session = this.sessionHelper.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(dumEntity);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			this.getLogger().error(e, e);
			return false;
		} finally {
			releaseSession(session);
		}
	}

	@SuppressWarnings("unchecked")
	protected List<Entity> findAll(Class<?> resultClazz) {
		List<Entity> result = null;
		Session session = this.getSessionHelper().openSession();
		result = session.createCriteria(resultClazz).list();
		return result;
	}

	public abstract boolean attach(Entity dumEntity);

	public abstract List<Entity> findAll();
}
