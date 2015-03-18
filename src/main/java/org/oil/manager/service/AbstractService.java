package org.oil.manager.service;

import java.util.List;

public abstract class AbstractService<T> {
	public abstract List<T> findAll();
}
