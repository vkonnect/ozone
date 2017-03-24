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

import com.vkonnect.ozone.model.Menu;
import com.vkonnect.ozone.services.MenuService;


@Controller
@RequestMapping("/menu")
public class MenuController
{

    @Autowired // two types : Singleton and Prototype
    MenuService menuService;

    static final Logger logger = Logger.getLogger(MenuController.class);


    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> addMenu (@RequestBody Menu menu)
    {
        try
        {
            menuService.addEntity(menu);
        } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Menu addition failed !", HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>("Menu added Successfully !", HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> updateUniversity (@RequestBody Menu menu)
    {
        try
        {
            menuService.updateEntity(menu);
        } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Menu updation failed !", HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>("Menu updated Successfully !", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<Menu> getMenu (@PathVariable("id") long id)
    {
        Menu menu = null;
        try
        {
            menu = menuService.getEntityById(id);
        } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Menu>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Menu>(menu, HttpStatus.OK);
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<Menu>> getMenu ()
    {
        List<Menu> menuList = null;
        try
        {
            menuList = menuService.getEntityList();
        } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<Menu>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Menu>>(menuList, HttpStatus.OK);
    }


    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> deleteMenu (@PathVariable("id") long id)
    {
        try
        {
            menuService.deleteEntity(id);
        } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Menu deletion failed !", HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>("Menu deleted Successfully !", HttpStatus.OK);
    }
}
