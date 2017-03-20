package com.vkonnect.ozone.dao;

import java.util.List;

import com.vkonnect.ozone.model.University;

public interface UniversityPool {

	public boolean addEntity(University university) throws Exception;
	public University getEntityById(long id) throws Exception;
	public List<University> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
	public boolean updateEntity(University university) throws Exception;
}
