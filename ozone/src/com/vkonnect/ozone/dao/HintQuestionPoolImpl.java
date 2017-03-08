package com.vkonnect.ozone.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.vkonnect.ozone.model.HintQuestion;

public class HintQuestionPoolImpl implements HintQuestionPool {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(HintQuestion hintQuestion) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(hintQuestion);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public HintQuestion getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		HintQuestion hintQuestion = (HintQuestion) session.load(HintQuestion.class,new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return hintQuestion;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HintQuestion> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<HintQuestion> hintQuestionList = session.createCriteria(HintQuestion.class).list();
		tx.commit();
		session.close();
		return hintQuestionList;
	}
	
	@Override
	public boolean deleteEntity(long id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(HintQuestion.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

	@Override
	public boolean updateHintQuestionEntity(long id) throws Exception {
		try {
			session = sessionFactory.openSession();
			Object obj = session.load(HintQuestion.class, id);
			tx = session.getTransaction();
			session.beginTransaction();
			session.saveOrUpdate(obj);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("Found Exception in HintQuestionPoolImple.updateHintQuestionEntity(long id):: "+ex);
			return false;
		}
		return true;
	}

}
