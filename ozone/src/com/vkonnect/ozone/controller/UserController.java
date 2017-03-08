package com.vkonnect.ozone.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vkonnect.ozone.model.Status;
import com.vkonnect.ozone.model.User;
import com.vkonnect.ozone.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	User getUser(@PathVariable("id") long id) {
		User user = null;
		try {
			user = userService.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<User> getUser() {

		List<User> userList = null;
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
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody
	List<User> searchUserList(@RequestParam("searchText") String searchText) {
		List<User> userList = null;
		try {
			userList = userService.searchUserEntity(searchText);
			return userList;
		} catch (Exception e) {
			return new ArrayList<User>();
		}
	}
	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status updateUser(@PathVariable("id") long id) {

		try {
			userService.updateUserEntity(id);
			return new Status(1, "User deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
