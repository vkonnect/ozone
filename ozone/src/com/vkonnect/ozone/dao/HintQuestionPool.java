package com.vkonnect.ozone.dao;

import java.util.List;

import com.vkonnect.ozone.model.HintQuestion;

public interface HintQuestionPool {

	public boolean addEntity(HintQuestion user) throws Exception;
	public HintQuestion getEntityById(long id) throws Exception;
	public List<HintQuestion> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
