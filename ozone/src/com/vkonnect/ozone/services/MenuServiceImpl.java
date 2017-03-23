package com.vkonnect.ozone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vkonnect.ozone.dao.MenuPool;
import com.vkonnect.ozone.model.Menu;

public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuPool menuPool;
	
	@Override
	public boolean addEntity(Menu menu) throws Exception {
		return menuPool.addEntity(menu);
	}

	@Override
	public Menu getEntityById(long id) throws Exception {
		return menuPool.getEntityById(id);
	}

	@Override
	public List<Menu> getEntityList() throws Exception {
		return menuPool.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return menuPool.deleteEntity(id);
	}

    @Override
    public boolean updateEntity (Menu menu)
        throws Exception
    {
        return menuPool.updateEntity(menu);
        
    }

}
