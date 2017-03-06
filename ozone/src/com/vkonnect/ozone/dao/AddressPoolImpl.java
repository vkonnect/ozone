package com.vkonnect.ozone.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.vkonnect.ozone.model.Address;


public class AddressPoolImpl
    implements AddressPool
{

    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;


    @Override
    public boolean addEntity (Address address)
        throws Exception
    {

        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(address);
        tx.commit();
        session.close();

        return false;
    }


    @Override
    public Address getEntityById (long id)
        throws Exception
    {
        session = sessionFactory.openSession();
        Address address = (Address) session.load(Address.class, new Long(id));
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return address;
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<Address> getEntityList ()
        throws Exception
    {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Address> addressList = session.createCriteria(Address.class).list();
        tx.commit();
        session.close();
        return addressList;
    }


    @Override
    public boolean deleteEntity (long id)
        throws Exception
    {
        session = sessionFactory.openSession();
        Object o = session.load(Address.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }

}
