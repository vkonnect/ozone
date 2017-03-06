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

import com.vkonnect.ozone.model.Status;
import com.vkonnect.ozone.model.University;
import com.vkonnect.ozone.services.UniversityService;

@Controller
@RequestMapping("/university")
public class UniversityController {

	@Autowired // two types : Singleton and Prototype
	UniversityService universityService;

	static final Logger logger = Logger.getLogger(UniversityController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addHintQuestion(@RequestBody University university) {
		try {
			universityService.addEntity(university);
			return new Status(1, "University added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	University getHintQuestion(@PathVariable("id") long id) {
		University hintQuestion = null;
		try {
			hintQuestion = universityService.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return hintQuestion;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<University> getHintQuestion() {

		List<University> hintQuestionList = null;
		try {
			hintQuestionList = universityService.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return hintQuestionList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteHintQuestion(@PathVariable("id") long id) {

		try {
			universityService.deleteEntity(id);
			return new Status(1, "University deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
