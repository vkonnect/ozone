package com.vkonnect.ozone.services;

import java.util.List;

import com.vkonnect.ozone.model.Menu;

public interface MenuService {
	public boolean addEntity(Menu menu) throws Exception;
	public Menu getEntityById(long id) throws Exception;
	public List<Menu> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
    public boolean updateEntity (Menu menu) throws Exception;
}
