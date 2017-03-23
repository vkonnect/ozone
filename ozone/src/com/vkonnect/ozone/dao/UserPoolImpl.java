package com.vkonnect.ozone.dao;


import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.vkonnect.ozone.model.Auditable;
import com.vkonnect.ozone.model.User;


public class UserPoolImpl
    implements UserPool
{

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;


    @Override
    public boolean addEntity (User user)
        throws Exception
    {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();

        return false;
    }


    @Override
    public User getEntityById (long id)
        throws Exception
    {
        session = sessionFactory.openSession();
        User user = (User) session.load(User.class, new Long(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return user;
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<User> getEntityList ()
        throws Exception
    {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<User> userList = session.createCriteria(User.class).list();
        tx.commit();
        session.close();
        return userList;
    }


    @Override
    public boolean deleteEntity (long id)
        throws Exception
    {
        session = sessionFactory.openSession();
        Object o = session.load(User.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }


    @SuppressWarnings("rawtypes")
    public boolean verifyUser (String userName, String password)
        throws Exception
    {
        boolean verified = false;
        session = sessionFactory.openSession();
        int userCount = 0;

        try
        {
            session.beginTransaction();
            String hql = "Select u1.username from User u1 where u1.username = :username and u1.password = :password";
            System.out.println(hql);
            Query query = session.createQuery(hql);
            query.setParameter("username", userName);
            query.setParameter("password", password);

            List result = query.list();
            if (result.size() > 0)
                verified = true;
            System.out.println("resultset:" + result);

        }
        catch (HibernateException e)
        {
            if (session.getTransaction() != null)
            {
                session.getTransaction().rollback();
            }
        }
        finally
        {
            session.close();
        }

        return verified;
    }


    @Override
    public boolean updateEntity (User user)
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
        // user.setAuditTrail(auditable);
        session.update(user);
        tx.commit();
        session.close();

        return true;
    }
}
