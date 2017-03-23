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

import com.vkonnect.ozone.model.MenuHeader;
import com.vkonnect.ozone.model.Status;
import com.vkonnect.ozone.model.University;
import com.vkonnect.ozone.services.MenuHeaderService;

@Controller
@RequestMapping("/menuheader")
public class MenuHeaderController {

	@Autowired // two types : Singleton and Prototype
	MenuHeaderService menuHeaderService;

	static final Logger logger = Logger.getLogger(MenuHeaderController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addMenuHeader(@RequestBody MenuHeader menuHeader) {
		try {
			menuHeaderService.addEntity(menuHeader);
			return new Status(1, "MenuHeader added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	  @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody Status updateUniversity (@RequestBody MenuHeader menuHeader)
	    {
	        try
	        {
	            menuHeaderService.updateEntity(menuHeader);
	            return new Status(1, "MenuHeader updated Successfully !");
	        }
	        catch (Exception e)
	        {
	            // e.printStackTrace();
	            return new Status(0, e.toString());
	        }

	    }
	  
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	MenuHeader getMenuHeader(@PathVariable("id") long id) {
		MenuHeader menuHeader = null;
		try {
			menuHeader = menuHeaderService.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuHeader;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<MenuHeader> getMenuHeader() {

		List<MenuHeader> menuHeaderList = null;
		try {
			menuHeaderList = menuHeaderService.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return menuHeaderList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteMenuHeader(@PathVariable("id") long id) {

		try {
			menuHeaderService.deleteEntity(id);
			return new Status(1, "MenuHeader deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
