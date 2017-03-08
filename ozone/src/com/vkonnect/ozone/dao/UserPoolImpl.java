package com.vkonnect.ozone.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import com.vkonnect.ozone.model.User;

public class UserPoolImpl implements UserPool {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(User user) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public User getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		User user = (User) session.load(User.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<User> userList = session.createCriteria(User.class)
				.list();
		tx.commit();
		session.close();
		return userList;
	}
	
	@Override
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(User.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

	
	@SuppressWarnings("rawtypes")
	public boolean verifyUser(String userName,String password) throws Exception
	{
		boolean verified = false;
		session = sessionFactory.openSession();
	    int userCount = 0;

	    try {
	            session.beginTransaction();
	            String hql = "Select user.id from User user where user.username=:userName and user.password=:password";      
	            System.out.println(hql);
	            Query query = session.createQuery(hql);
	            query.setParameter(":userName",userName);
	            query.setParameter(":password", password);
	            
	            List result = query.list();

	            System.out.println("resultset:"+result);

	            Iterator iterator = result.iterator();
	            while(iterator.hasNext()){
	                userCount = (int) iterator.next();
	        }
	    } catch (HibernateException e) {
	        if (session.getTransaction() != null) {
	            session.getTransaction().rollback();
	        }
	    } finally {
	        session.close();
	    }
		if (userCount > 0)
			verified = true;
	    return verified;
	}

	@Override
	public List<User> searchEntityList(String searchTerm) throws Exception {
		try {
			session = sessionFactory.getCurrentSession();
			FullTextSession fullTextSession = Search.getFullTextSession(session);
			
			QueryBuilder queryBuild = fullTextSession.getSearchFactory()
			           .buildQueryBuilder().forEntity(User.class).get();
			
			org.apache.lucene.search.Query query = queryBuild.keyword().onField("firstName").matching(searchTerm).createQuery();
			org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(query, User.class);
			List<User> userList = hibQuery.list();
	        return userList;
		} catch (Exception ex) {
			System.out.println("Found Exception in UserPoolImpl.searchEntityList(String searchTerm):: "+ex);
			ex.printStackTrace();
			return new ArrayList<User>();
		}
	}
	
	@Override
	public boolean updateUser(long id) throws Exception {
		session = sessionFactory.openSession();
		try {
			Object userObject = session.load(User.class, id);
			tx = session.getTransaction();
			session.beginTransaction();
			session.update(userObject);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("Found Exception in UserPoolImpl.updateUser(long id):: "+ex);
			return false;
		}
		return true;
	}
}
