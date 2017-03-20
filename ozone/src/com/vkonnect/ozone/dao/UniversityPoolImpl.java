package com.vkonnect.ozone.dao;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.vkonnect.ozone.model.Auditable;
import com.vkonnect.ozone.model.University;
import com.vkonnect.ozone.model.User;


public class UniversityPoolImpl
    implements UniversityPool
{

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;


    @Override
    public boolean addEntity (University university)
        throws Exception
    {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Auditable auditable = new Auditable();
        auditable.setActive(true);
        auditable.setCreatedBy("nilesh");
        auditable.setCreatedDate(new Date());
        auditable.setDeleted(false);
        auditable.setModifiedBy("nilesh");
        auditable.setModifiedDate(new Date());
        university.setAuditTrail(auditable);
        session.save(university);
        tx.commit();
        session.close();

        return true;
    }


    @Override
    public University getEntityById (long id)
        throws Exception
    {
        session = sessionFactory.openSession();
        University university = (University) session.load(University.class, new Long(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return university;
       
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<University> getEntityList ()
        throws Exception
    {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<University> hintQuestionList = session.createCriteria(University.class).list();
        tx.commit();
        session.close();
        return hintQuestionList;
    }


    @Override
    public boolean deleteEntity (long id)
        throws Exception
    {
        session = sessionFactory.openSession();
        Object o = session.load(University.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return true;
    }


    @Override
    public boolean updateEntity (University university)
        throws Exception
    {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Auditable auditable = new Auditable();
        auditable.setActive(true);
        auditable.setCreatedBy("nilesh");
        auditable.setCreatedDate(new Date());
        auditable.setDeleted(false);
        auditable.setModifiedBy("nilesh");
        auditable.setModifiedDate(new Date());
        university.setAuditTrail(auditable);
        session.update(university);
        tx.commit();
        session.close();

        return true;
    }

}
