package com.vkonnect.ozone.services;

import java.util.List;

import com.vkonnect.ozone.model.HintQuestion;

public interface HintQuestionService {
	public boolean addEntity(HintQuestion hintQuestion) throws Exception;
	public HintQuestion getEntityById(long id) throws Exception;
	public List<HintQuestion> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
	public boolean updateHintQuestionEntity(long id) throws Exception;
}
