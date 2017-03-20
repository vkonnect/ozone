package com.vkonnect.ozone.services;

import java.util.List;

import com.vkonnect.ozone.model.MenuHeader;

public interface MenuHeaderService {
	public boolean addEntity(MenuHeader menuHeader) throws Exception;
	public MenuHeader getEntityById(long id) throws Exception;
	public List<MenuHeader> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
	public boolean updateEntity(MenuHeader menuHeader) throws Exception;
}
