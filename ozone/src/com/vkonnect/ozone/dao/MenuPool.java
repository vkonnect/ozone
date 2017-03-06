package com.vkonnect.ozone.dao;

import java.util.List;

import com.vkonnect.ozone.model.Menu;

public interface MenuPool {

	public boolean addEntity(Menu menu) throws Exception;
	public Menu getEntityById(long id) throws Exception;
	public List<Menu> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
