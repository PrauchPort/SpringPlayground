package com.apress.todo;

import java.util.Collection;

public interface CommonRepository<T> {
	
	public T save(T domain);
	public Iterable<T> save(Collection<T> collection);
	public T findByID(String id);
	public T delete(String id);
	public Iterable<T> findAll();

}
