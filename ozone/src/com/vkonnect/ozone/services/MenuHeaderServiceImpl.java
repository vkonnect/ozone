package com.vkonnect.ozone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vkonnect.ozone.dao.MenuHeaderPool;
import com.vkonnect.ozone.model.MenuHeader;

public class MenuHeaderServiceImpl implements MenuHeaderService {

	@Autowired
	MenuHeaderPool menuHeaderPool;
	
	@Override
	public boolean addEntity(MenuHeader menuHeader) throws Exception {
		return menuHeaderPool.addEntity(menuHeader);
	}

	@Override
	public MenuHeader getEntityById(long id) throws Exception {
		return menuHeaderPool.getEntityById(id);
	}

	@Override
	public List<MenuHeader> getEntityList() throws Exception {
		return menuHeaderPool.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return menuHeaderPool.deleteEntity(id);
	}

}
