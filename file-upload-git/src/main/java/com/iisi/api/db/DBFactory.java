package com.iisi.api.db;

import java.util.List;

public interface DBFactory {
	
	public <T> List<?> query(List<T> params, String sql, Class<?> clazz);
	
	public <T> void update(T t);
	
	public <T> void delete(T t);
	
	public <T> void insert(T t);
}
