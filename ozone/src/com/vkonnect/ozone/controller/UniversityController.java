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

import com.vkonnect.ozone.model.University;
import com.vkonnect.ozone.services.UniversityService;


@Controller
@RequestMapping("/university")
public class UniversityController
{

    @Autowired // two types : Singleton and Prototype
    UniversityService universityService;

    static final Logger logger = Logger.getLogger(UniversityController.class);


    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> addUniversity (@RequestBody University university)
    {
        try
        {
            universityService.addEntity(university);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	return new ResponseEntity<String>("University insertion failed !", HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<String>("University added Successfully !", HttpStatus.OK);
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> updateUniversity (@RequestBody University university)
    {
        try
        {
            universityService.updateEntity(university);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	return new ResponseEntity<String>("University updation failed !", HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<String>("University updated Successfully !", HttpStatus.OK);
    }
    

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<University> getUniversity(@PathVariable("id") long id) {
		University university = null;
		try {
			university = universityService.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<University>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<University>(university, HttpStatus.OK);
	}




    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<University>> getUniversity ()
    {
        List<University> universityList = null;
        try
        {
            universityList = universityService.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<University>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<University>>(universityList, HttpStatus.OK);
    }


    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> deleteHintQuestion (@PathVariable("id") long id)
    {
        try
        {
            universityService.deleteEntity(id);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	return new ResponseEntity<String>("University deletion failed !", HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<String>("University deleted Successfully !", HttpStatus.OK);
    }
}
