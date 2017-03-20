package com.vkonnect.ozone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vkonnect.ozone.dao.UniversityPool;
import com.vkonnect.ozone.model.University;

public class UniversityServiceImpl implements UniversityService {

	@Autowired
	UniversityPool universityPool;
	
	@Override
	public boolean addEntity(University university) throws Exception {
		return universityPool.addEntity(university);
	}

	@Override
	public University getEntityById(long id) throws Exception {
		return universityPool.getEntityById(id);
	}

	@Override
	public List<University> getEntityList() throws Exception {
		return universityPool.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return universityPool.deleteEntity(id);
	}

    @Override
    public boolean updateEntity (University university)
        throws Exception
    {
        return universityPool.updateEntity(university);
    }

}
