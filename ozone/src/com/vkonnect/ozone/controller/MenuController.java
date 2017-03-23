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

import com.vkonnect.ozone.model.Menu;
import com.vkonnect.ozone.model.Status;
import com.vkonnect.ozone.services.MenuService;


@Controller
@RequestMapping("/menu")
public class MenuController
{

    @Autowired // two types : Singleton and Prototype
    MenuService menuService;

    static final Logger logger = Logger.getLogger(MenuController.class);


    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Status addMenu (@RequestBody Menu menu)
    {
        try
        {
            menuService.addEntity(menu);
            return new Status(1, "Menu added Successfully !");
        }
        catch (Exception e)
        {
            // e.printStackTrace();
            return new Status(0, e.toString());
        }

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Status updateUniversity (@RequestBody Menu menu)
    {
        try
        {
            menuService.updateEntity(menu);
            return new Status(1, "Menu updated Successfully !");
        }
        catch (Exception e)
        {
            // e.printStackTrace();
            return new Status(0, e.toString());
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Menu getMenu (@PathVariable("id") long id)
    {
        Menu menu = null;
        try
        {
            menu = menuService.getEntityById(id);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return menu;
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody List<Menu> getMenu ()
    {

        List<Menu> menuList = null;
        try
        {
            menuList = menuService.getEntityList();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return menuList;
    }


    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public @ResponseBody Status deleteMenu (@PathVariable("id") long id)
    {

        try
        {
            menuService.deleteEntity(id);
            return new Status(1, "Menu deleted Successfully !");
        }
        catch (Exception e)
        {
            return new Status(0, e.toString());
        }

    }
}
