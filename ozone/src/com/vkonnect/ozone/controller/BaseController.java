package com.vkonnect.ozone.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

	    @Autowired
	    protected HttpSession httpSession;

	    @Autowired(required = true)
	    protected HttpServletRequest request;
}
