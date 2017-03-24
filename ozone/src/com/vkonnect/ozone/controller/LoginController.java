package com.vkonnect.ozone.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vkonnect.ozone.model.Login;
import com.vkonnect.ozone.model.Status;
import com.vkonnect.ozone.services.UserService;


/**
 * Rest interface to expose methods to perform login.
 */
@Controller
@RequestMapping("/system")
public class LoginController
{


    @Autowired
    private HttpSession httpSession;

    @Autowired(required = true)
    private HttpServletRequest request;

    @Autowired // two types : Singleton and Prototype
    UserService userService;

    private int cSESSION_TIMEOUT_SEC = 60 * 15;


    /**
     * Facilitates user to authenticate itelf into the system and get privelaged to access system resources.
     * 
     * @param loginStruct
     * @return A Response object
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response login (@RequestBody Login loginStruct)
    {
        String userName = loginStruct.username;
        String userPassword = loginStruct.password;

        // To be verfied at DB.
        boolean authenticated = true;
        try
        {
            authenticated = userService.verifyUser(userName, userPassword);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            // e.printStackTrace();
        }
        String message = "";
        int responseCode = 200;
        if (authenticated)
        {
            message = "Login Sucessfull";
            httpSession = request.getSession(true);
            httpSession.setAttribute("Secured token", httpSession.getId());
            httpSession.setMaxInactiveInterval(cSESSION_TIMEOUT_SEC);
        }
        else
        {
            message = "Login Unsucessfull";
            responseCode = 401;
        }

        Response res = new Response();
        res.setResponseCode(responseCode);
        res.setMessage(message);
        return res;
    }


    // TODO : user already logged in but trying to logged in again
    // TODO : Logout request for user who is not logged in


    /**
     * Facilitates user to authenticate itelf into the system and get privelaged to access system resources.
     * 
     * @param loginStruct
     * @return A Response object
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response logout ()
    {
        Response res = new Response();
        res.setMessage("Logout Sucessfull");
        httpSession = request.getSession();
        httpSession.invalidate();
        return res;
    }

    @RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public @ResponseBody
	Status forgotPassword(@RequestParam("username") String userName, @RequestParam("id") long hintQuestionId, 
							@RequestParam("answer") String hintAnswer, @RequestParam("newPassword") String newPassword) {

		try {
			userService.updateUserPassword(userName, hintQuestionId, hintAnswer, newPassword);
			return new Status(1, "User password updated Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
