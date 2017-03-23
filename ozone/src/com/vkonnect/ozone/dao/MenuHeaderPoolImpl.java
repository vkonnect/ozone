package com.vkonnect.ozone.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.vkonnect.ozone.model.Auditable;
import com.vkonnect.ozone.model.MenuHeader;
import com.vkonnect.ozone.model.User;

public class MenuHeaderPoolImpl implements MenuHeaderPool {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(MenuHeader menuHeader) throws Exception {

	    session = sessionFactory.openSession();
        tx = session.beginTransaction();
        Auditable auditable = new Auditable();
        auditable.setActive(true);
        auditable.setCreatedBy("nilesh");
        auditable.setCreatedDate(new Date());
        auditable.setDeleted(false);
        auditable.setModifiedBy("nilesh");
        auditable.setModifiedDate(new Date());
        menuHeader.setAuditTrail(auditable);
        session.save(menuHeader);
        tx.commit();
        session.close();
        return true;
	}

	@Override
	public MenuHeader getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		MenuHeader menuHeader = (MenuHeader) session.load(MenuHeader.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return menuHeader;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuHeader> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<MenuHeader> userList = session.createCriteria(MenuHeader.class)
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

    @Override
    public boolean updateEntity (MenuHeader menuHeader)
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
        menuHeader.setAuditTrail(auditable);
        session.update(menuHeader);
        tx.commit();
        session.close();

        return true;
    }

}
