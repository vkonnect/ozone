package com.vkonnect.ozone.dao;

import java.util.List;

import com.vkonnect.ozone.model.KeyPerson;

public interface KeyPersonPool {

	public boolean addEntity(KeyPerson keyPerson) throws Exception;
	public KeyPerson getEntityById(long id) throws Exception;
	public List<KeyPerson> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
