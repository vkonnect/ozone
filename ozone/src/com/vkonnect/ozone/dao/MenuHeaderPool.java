package com.vkonnect.ozone.dao;

import java.util.List;

import com.vkonnect.ozone.model.MenuHeader;

public interface MenuHeaderPool {

	public boolean addEntity(MenuHeader menuHeader) throws Exception;
	public MenuHeader getEntityById(long id) throws Exception;
	public List<MenuHeader> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
	public boolean updateMenuHeaderEntity(long id) throws Exception;
}
