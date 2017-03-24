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

import com.vkonnect.ozone.dto.UserDTO;
import com.vkonnect.ozone.model.User;
import com.vkonnect.ozone.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired // two types : Singleton and Prototype
	UserService userService;

	static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> addUser(@RequestBody User user) {
		try {
			userService.addEntity(user);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("User insertion failed !", HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>("User added Successfully !", HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<String> updateUser(@RequestBody User user) {
		try {
			userService.updateEntity(user);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("User updation failed !", HttpStatus.EXPECTATION_FAILED);

		}
		return new ResponseEntity<String>("User updated Successfully !", HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<UserDTO> getUser(@PathVariable("id") long id) {
		UserDTO user = null;
		try {
			user = userService.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<UserDTO>> getUser() {

		List<UserDTO> userList = null;
		try {
			userList = userService.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<UserDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<UserDTO>>(userList, HttpStatus.OK);
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> deleteUser(@PathVariable("id") long id) {

		try {
			userService.deleteEntity(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("User deletion failed !", HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>("User deleted Successfully !", HttpStatus.OK);
	}
}
