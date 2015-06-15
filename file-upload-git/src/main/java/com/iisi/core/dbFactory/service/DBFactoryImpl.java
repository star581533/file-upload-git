//http://blog.csdn.net/foamflower/article/details/4121611
package com.iisi.core.dbFactory.service;

import java.util.List;
//http://www.blogjava.net/dreamstone/archive/2007/07/29/133071.html





import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.iisi.api.db.DBFactory;
import com.iisi.api.db.DBSMain;
import com.iisi.api.execption.FileSysException;

@Component
@Qualifier("dbFactory")
public class DBFactoryImpl implements DBFactory{
	
	//http://blog.csdn.net/augus6/article/details/9745451
	//http://www.ayblogs.com/m/?post=293
	@Inject
	private SessionFactory sessionFactory;
		
	public <T> List<?> query(List<T> params, String sql, Class<?> clazz){		
		
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(clazz);
		
		for(int param=0;param < params.size();param++){
			query.setParameter(param, params.get(param));
		}
						
		List<?> lists = query.list();
		
		System.out.println("sql = " + sql);
		
//		List<?> lists = getHibernateTemplate().find(sql, params);
		
		this.flush();
		return lists;
	}
	
	public <T> void update(T t){
		//http://blog.csdn.net/jackieliulixi/article/details/24777957
		sessionFactory.getCurrentSession().update(t);
//		getHibernateTemplate().update(t);
	}
	
	@Transactional
	public <T> void delete(T t){
		sessionFactory.getCurrentSession().delete(t);
//		getHibernateTemplate().delete(t);
	}
	
	//http://www.codedata.com.tw/java/hibernate-lazy-loading/
	@Transactional
	public <T> void insert(T t){
		try{
			Class entityClass = t.getClass();
			String tableName = entityClass.getName();
			System.out.println("tableName = " + tableName);
			System.out.println("t.toString = " + t.toString());
			sessionFactory.getCurrentSession().save(tableName, t);
//			getHibernateTemplate().save(tableName, t);
		}catch(FileSysException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
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

	@Override
	public DBSMain getDB() {
		return null;
	}
}
