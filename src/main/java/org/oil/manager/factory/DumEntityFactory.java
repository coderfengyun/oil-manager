package org.oil.manager.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DumEntityFactory<T> {
	private Class<?> targetClass;

	public DumEntityFactory(Class<?> targetClass) {
		this.targetClass = targetClass;
	}

	@SuppressWarnings("unchecked")
	public T buildWithoutId() {
		Constructor<?> defaultContructor = targetClass.getConstructors()[0];
		T result = null;
		try {
			result = (T) defaultContructor.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		this.targetClass.getDeclaredFields();
		return result;
	}
}
