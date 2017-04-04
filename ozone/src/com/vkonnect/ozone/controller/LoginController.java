package com.vkonnect.ozone.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vkonnect.ozone.dto.LoginDTO;
import com.vkonnect.ozone.dto.ResetPasswordDTO;
import com.vkonnect.ozone.services.UserService;


/**
 * Rest interface to expose methods to perform login.
 */
@Controller
@RequestMapping("/system")
public class LoginController extends BaseController
{

    @Autowired // two types : Singleton and Prototype
    UserService userService;

    private int cSESSION_TIMEOUT_SEC = 60 * 15;


    /**
     * Facilitates user to authenticate itelf into the system and get privelaged to access system resources.
     * 
     * @param loginDTO
     * @return A Response object
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
		String userName = loginDTO.username;
		String userPassword = loginDTO.password;

		boolean authenticated = true;
		try {
			authenticated = userService.verifyUser(userName, userPassword);
			httpSession = request.getSession(true);
			httpSession.setAttribute("Secured token", httpSession.getId());
			httpSession.setMaxInactiveInterval(cSESSION_TIMEOUT_SEC);
		} catch (Exception e) {
			return new ResponseEntity<String>("Login Unsucessfull", HttpStatus.UNAUTHORIZED);
		}
		if (!authenticated) {
			return new ResponseEntity<String>("Login Unsucessfull", HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<String>("Login Sucessfull", HttpStatus.OK);
	}


    // TODO : user already logged in but trying to logged in again
    // TODO : Logout request for user who is not logged in


    /**
     * Facilitates user to authenticate itelf into the system and get privelaged to access system resources.
     * 
     * @return A Response object
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> logout ()
    {
        Response res = new Response();
        res.setMessage("Logout Sucessfull");
        httpSession = request.getSession();
        httpSession.invalidate();
        return new ResponseEntity<String>("Logout Successfully !", HttpStatus.OK);
    }

    @RequestMapping(value = "/forgotpassword", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	ResponseEntity<String> forgotPassword(@RequestBody ResetPasswordDTO restpasswordDTO) {

		try {
			userService.updateUserPassword(restpasswordDTO.username, restpasswordDTO.hintquestionid, restpasswordDTO.answer, restpasswordDTO.newpassword);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("User password reset failed !", HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<String>("User password reset Successfully !", HttpStatus.OK);
	}
}
