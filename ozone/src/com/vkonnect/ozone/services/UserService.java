package com.vkonnect.ozone.services;

import java.util.List;

import com.vkonnect.ozone.model.User;

public interface UserService {
	public boolean addEntity(User user) throws Exception;
	public User getEntityById(long id) throws Exception;
	public List<User> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
	public boolean verifyUser(String userName,String password) throws Exception;
	public List<User> searchUserEntity(String searchText) throws Exception;
	public boolean updateEntity(long id) throws Exception;
}
