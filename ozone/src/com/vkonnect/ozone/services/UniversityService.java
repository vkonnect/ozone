package com.vkonnect.ozone.services;

import java.util.List;

import com.vkonnect.ozone.model.University;

public interface UniversityService {
	public boolean addEntity(University hintQuestion) throws Exception;
	public University getEntityById(long id) throws Exception;
	public List<University> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
