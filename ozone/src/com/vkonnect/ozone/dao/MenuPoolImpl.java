package com.vkonnect.ozone.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.vkonnect.ozone.model.Auditable;
import com.vkonnect.ozone.model.Menu;

public class MenuPoolImpl implements MenuPool {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(Menu menu) throws Exception {

	    session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Auditable auditable = new Auditable();
        auditable.setActive(true);
        auditable.setCreatedBy("nilesh");
        auditable.setCreatedDate(new Date());
        auditable.setDeleted(false);
        auditable.setModifiedBy("nilesh");
        auditable.setModifiedDate(new Date());
        menu.setAuditTrail(auditable);
        session.save(menu);
        tx.commit();
        session.close();
        return true;
	}

	@Override
	public Menu getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Menu menu = (Menu) session.load(Menu.class,new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return menu;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Menu> menuList = session.createCriteria(Menu.class).list();
		tx.commit();
		session.close();
		return menuList;
	}
	
	@Override
	public boolean deleteEntity(long id) throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Menu.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

    @Override
    public boolean updateEntity (Menu menu)
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
        menu.setAuditTrail(auditable);
        session.update(menu);
        tx.commit();
        session.close();

        return true;
    }

}
