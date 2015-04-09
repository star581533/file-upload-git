//http://blog.csdn.net/foamflower/article/details/4121611
package com.iisi.core.dbFactory.service;

import java.util.List;
//http://www.blogjava.net/dreamstone/archive/2007/07/29/133071.html

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.iisi.api.db.DBFactory;

@Component
@Qualifier("dbFactory")
public class DBFactoryImpl implements DBFactory{
	
	//http://blog.csdn.net/augus6/article/details/9745451
	@Inject
	private SessionFactory sessionFactory;
		
	public <T> List<?> query(List<T> params, String sql, Class<?> clazz){		
		
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(clazz);
		for(int param=0;param < params.size();param++){
			query.setParameter(param, params.get(param));
		}
		
		this.flush();
		
		List<?> lists = query.list();
		return lists;
	}
	
	public <T> void update(T t){
		sessionFactory.getCurrentSession().update(t);
	}
	
	public <T> void delete(T t){
		sessionFactory.getCurrentSession().delete(t);
	}
	
	public <T> void insert(T t){
		System.out.println("---------------------insert------------------------");
//		sessionFactory.getCurrentSession().persist(t);
		Class entityClass = t.getClass();
		String tableName = entityClass.getName();
		System.out.println("tableName = " + tableName);
		System.out.println("t.toString = " + t.toString());
		sessionFactory.getCurrentSession().save(tableName, t);
	}

	private void flush(){
		sessionFactory.getCurrentSession().flush();
	}
	
	public SessionFactory getSesonFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
