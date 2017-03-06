package com.vkonnect.ozone.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vkonnect.ozone.model.HintQuestion;
import com.vkonnect.ozone.model.Status;
import com.vkonnect.ozone.services.HintQuestionService;

@Controller
@RequestMapping("/hintquestion")
public class HintQuestionController {

	@Autowired // two types : Singleton and Prototype
	HintQuestionService hintQuestionService;

	static final Logger logger = Logger.getLogger(HintQuestionController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addHintQuestion(@RequestBody HintQuestion hintQuestion) {
		try {
			hintQuestionService.addEntity(hintQuestion);
			return new Status(1, "HintQuestion added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	HintQuestion getHintQuestion(@PathVariable("id") long id) {
		HintQuestion hintQuestion = null;
		try {
			hintQuestion = hintQuestionService.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return hintQuestion;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<HintQuestion> getHintQuestion() {

		List<HintQuestion> hintQuestionList = null;
		try {
			hintQuestionList = hintQuestionService.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return hintQuestionList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteHintQuestion(@PathVariable("id") long id) {

		try {
			hintQuestionService.deleteEntity(id);
			return new Status(1, "HintQuestion deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
