package org.oil.manager.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
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

	protected final boolean attachCore(Aggregate dumEntity) {
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

	public final Entity find(int id, Class<?> clazz) {
		Session session = this.getSessionHelper().openSession();
		@SuppressWarnings("unchecked")
		Entity result = (Entity) session.get(clazz, id);
		return result;
	}

	public boolean updateCore(Entity well) {
		Session session = this.getSessionHelper().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(well);
			transaction.commit();
			return true;
		} catch (Exception e) {
			this.getLogger().error(e, e);
			transaction.rollback();
			return false;
		} finally {
			releaseSession(session);
		}
	}

	protected List<Entity> findAll(Class<?> resultClazz) {
		return findAllByCore(null, resultClazz);
	}

	@SuppressWarnings("unchecked")
	protected List<Entity> findAllByCore(Criterion specification, Class<?> clazz) {
		List<Entity> result = null;
		Session session = this.getSessionHelper().openSession();
		Criteria criteria = session.createCriteria(clazz);
		if (specification != null) {
			criteria.add(specification);
		}
		result = criteria.list();
		return result;
	}

	public abstract boolean attach(Entity dumEntity);

	public abstract List<Entity> findAll();

	public abstract List<Entity> findAllBy(Criterion specification);
}
