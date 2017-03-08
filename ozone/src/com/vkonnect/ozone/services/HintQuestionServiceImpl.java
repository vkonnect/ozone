package com.vkonnect.ozone.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vkonnect.ozone.dao.HintQuestionPool;
import com.vkonnect.ozone.model.HintQuestion;

public class HintQuestionServiceImpl implements HintQuestionService {

	@Autowired
	HintQuestionPool hintQuestionPool;
	
	@Override
	public boolean addEntity(HintQuestion hintQuestion) throws Exception {
		return hintQuestionPool.addEntity(hintQuestion);
	}

	@Override
	public HintQuestion getEntityById(long id) throws Exception {
		return hintQuestionPool.getEntityById(id);
	}

	@Override
	public List<HintQuestion> getEntityList() throws Exception {
		return hintQuestionPool.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return hintQuestionPool.deleteEntity(id);
	}

	@Override
	public boolean updateHintQuestionEntity(long id) throws Exception {
		return hintQuestionPool.updateHintQuestionEntity(id);
	}

}
