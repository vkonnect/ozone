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

import com.vkonnect.ozone.model.MenuHeader;
import com.vkonnect.ozone.services.MenuHeaderService;

@Controller
@RequestMapping("/menuheader")
public class MenuHeaderController {

	@Autowired // two types : Singleton and Prototype
	MenuHeaderService menuHeaderService;

	static final Logger logger = Logger.getLogger(MenuHeaderController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> addMenuHeader(@RequestBody MenuHeader menuHeader) {
		try {
			menuHeaderService.addEntity(menuHeader);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("MenuHeader addition failed !", HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>("MenuHeader a Successfully !", HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> updateUniversity(@RequestBody MenuHeader menuHeader) {
		try {
			menuHeaderService.updateEntity(menuHeader);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("MenuHeader updation failed !", HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>("MenuHeader updated Successfully !", HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<MenuHeader> getMenuHeader(@PathVariable("id") long id) {
		MenuHeader menuHeader = null;
		try {
			menuHeader = menuHeaderService.getEntityById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<MenuHeader>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<MenuHeader>(menuHeader, HttpStatus.OK);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<MenuHeader>> getMenuHeader() {

		List<MenuHeader> menuHeaderList = null;
		try {
			menuHeaderList = menuHeaderService.getEntityList();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<MenuHeader>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<MenuHeader>>(menuHeaderList, HttpStatus.OK);
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> deleteMenuHeader(@PathVariable("id") long id) {

		try {
			menuHeaderService.deleteEntity(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("MenuHeader deletion failed !", HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>("MenuHeader deleted Successfully !", HttpStatus.OK);
	}
}
