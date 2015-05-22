package com.iisi.api.db;

import java.util.List;

public interface BaseFactory {
	/**
	 * 查詢資料
	 * @param params 條件
	 * @param sql SQL語法
	 * @param clazz 類別名稱
	 * @return
	 */
	public <T> List<?> query(List<T> params, String sql, Class<?> clazz);
	
	/**
	 * 更新資料
	 * @param t 物件
	 */
	public <T> void update(T t);
	
	/**
	 * 刪除資料
	 * @param t 物件
	 */
	public <T> void delete(T t);
	
	/**
	 * 新增資料
	 * @param t 物件
	 */
	public <T> void insert(T t);
}
