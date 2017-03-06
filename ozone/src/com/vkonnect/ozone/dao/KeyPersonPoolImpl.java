package com.vkonnect.ozone.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.vkonnect.ozone.model.KeyPerson;


public class KeyPersonPoolImpl
    implements KeyPersonPool
{

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;


    @Override
    public boolean addEntity (KeyPerson keyPerson)
        throws Exception
    {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(keyPerson);
        tx.commit();
        session.close();

        return false;
    }


    @Override
    public KeyPerson getEntityById (long id)
        throws Exception
    {
        session = sessionFactory.openSession();
        KeyPerson keyPerson = (KeyPerson) session.load(KeyPerson.class, new Long(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return keyPerson;
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<KeyPerson> getEntityList ()
        throws Exception
    {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<KeyPerson> keyPersonList = session.createCriteria(KeyPerson.class).list();
        tx.commit();
        session.close();
        return keyPersonList;
    }


    @Override
    public boolean deleteEntity (long id)
        throws Exception
    {
        session = sessionFactory.openSession();
        Object o = session.load(KeyPerson.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

}
