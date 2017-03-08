package com.vkonnect.ozone.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.vkonnect.ozone.model.University;

public class UniversityPoolImpl implements UniversityPool {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(University university) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(university);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public University getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		University hintQuestion = (University) session.load(University.class,new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return hintQuestion;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<University> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<University> hintQuestionList = session.createCriteria(University.class).list();
		tx.commit();
		session.close();
		return hintQuestionList;
	}
	
	@Override
	public boolean deleteEntity(long id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(University.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}
	
	@Override
	public boolean updateUniversityById(long id) throws Exception {
		session = sessionFactory.openSession();
		try {
			Object obj = session.load(University.class, id);
			tx = session.beginTransaction();
			session.saveOrUpdate(obj);
			tx.commit();
			session.close();
		} catch (Exception ex) {
			System.out.println("Found Exception in UniversityPoolImple.updateUniversityById(long id):: "+ex);
			return false;
		}
		return true;
	}

}
