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

import com.vkonnect.ozone.dto.UserDTO;
import com.vkonnect.ozone.model.Status;
import com.vkonnect.ozone.model.User;
import com.vkonnect.ozone.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	@Autowired // two types : Singleton and Prototype
	UserService userService;

	static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addUser(@RequestBody User user) {
		try {
			userService.addEntity(user);
			return new Status(1, "User added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}
	
	  @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody Status updateUser (@RequestBody User user)
	    {
	        try
	        {
	            userService.updateEntity(user);
	            return new Status(1, "User Updated Successfuly ");
	        }
	        catch (Exception e)
	        {
	            // e.printStackTrace();
	            return new Status(0, e.toString());
	        }

	    }

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	UserDTO getUser(@PathVariable("id") long id) {
		UserDTO user = null;
		try {
			user = userService.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<UserDTO> getUser() {

		List<UserDTO> userList = null;
		try {
			userList = userService.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteUser(@PathVariable("id") long id) {

		try {
			userService.deleteEntity(id);
			return new Status(1, "User deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
