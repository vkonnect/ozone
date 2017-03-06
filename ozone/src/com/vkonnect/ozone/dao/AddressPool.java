package com.vkonnect.ozone.dao;

import java.util.List;

import com.vkonnect.ozone.model.Address;

public interface AddressPool {

	public boolean addEntity(Address address) throws Exception;
	public Address getEntityById(long id) throws Exception;
	public List<Address> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
