package com.vkonnect.ozone.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vkonnect.ozone.model.HintQuestion;
import com.vkonnect.ozone.services.HintQuestionService;

@Controller
@RequestMapping("/hintquestion")
public class HintQuestionController {

	@Autowired // two types : Singleton and Prototype
	HintQuestionService hintQuestionService;

	static final Logger logger = Logger.getLogger(HintQuestionController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> addHintQuestion(@RequestBody HintQuestion hintQuestion) {
		try {
			hintQuestionService.addEntity(hintQuestion);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("HintQuestion addition failed !", HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>("HintQuestion added Successfully !", HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<HintQuestion> getHintQuestion(@PathVariable("id") long id) {
		HintQuestion hintQuestion = null;
		try {
			hintQuestion = hintQuestionService.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<HintQuestion>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<HintQuestion>(hintQuestion, HttpStatus.OK);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<HintQuestion>> getHintQuestion() {

		List<HintQuestion> hintQuestionList = null;
		try {
			hintQuestionList = hintQuestionService.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<HintQuestion>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<HintQuestion>>(hintQuestionList, HttpStatus.OK);
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> deleteHintQuestion(@PathVariable("id") long id) {

		try {
			hintQuestionService.deleteEntity(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("HintQuestion deletion failed !", HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>("HintQuestion deleted Successfully !", HttpStatus.OK);

	}
}
