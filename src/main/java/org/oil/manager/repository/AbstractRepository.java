package org.oil.manager.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.oil.manager.helper.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractRepository<Entity> {
	private SessionHelper sessionHelper;
	private Logger logger = Logger.getLogger(this.getClass());
	private final Class<?> clazz;

	AbstractRepository(Class<?> clazz) {
		this.clazz = clazz;
	}

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

	public final boolean attach(Entity dumEntity) {
		Session session = this.sessionHelper.getCurrentSession();
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

	public final boolean detach(Serializable id) {
		Session session = this.sessionHelper.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			@SuppressWarnings("unchecked")
			Entity result = (Entity) session.get(this.clazz, id);
			if (result == null) {
				return false;
			}
			session.delete(result);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			this.logger.error(e, e);
			return false;
		} finally {
			releaseSession(session);
		}
	}

	public final boolean detach(Entity dumEntity) {
		Session session = this.sessionHelper.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(dumEntity);
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

	public boolean update(Entity well) {
		Session session = this.getSessionHelper().getCurrentSession();
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

	public final Optional<Entity> find(Serializable id) {
		Session session = this.getSessionHelper().getCurrentSession();
		@SuppressWarnings("unchecked")
		Entity result = (Entity) session.get(this.clazz, id);
		return Optional.ofNullable(result);
	}

	public List<Entity> findAll() {
		return findAllBy(null);
	}

	@SuppressWarnings("unchecked")
	public List<Entity> findAllBy(Criterion specification) {
		List<Entity> result = null;
		Session session = this.getSessionHelper().getCurrentSession();
		Criteria criteria = session.createCriteria(this.clazz);
		if (specification != null) {
			criteria.add(specification);
		}
		result = criteria.list();
		return result;
	}

}
