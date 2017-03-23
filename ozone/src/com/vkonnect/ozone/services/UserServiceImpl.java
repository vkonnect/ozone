package com.vkonnect.ozone.services;


import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

import com.vkonnect.ozone.dao.UserPool;
import com.vkonnect.ozone.dto.HintQuestionDTO;
import com.vkonnect.ozone.dto.UserDTO;
import com.vkonnect.ozone.model.User;
import com.vkonnect.ozone.utils.CipherUtil;


public class UserServiceImpl
    implements UserService
{

    @Autowired
    UserPool userPool;

    private static String SALT = "OZONE";


    @Override
    public boolean addEntity (User user)
        throws Exception
    {
        String encryptpwd = user.getPassword();
        encryptpwd = CipherUtil.encrypt(encryptpwd, SALT);
        user.setPassword(encryptpwd);
        return userPool.addEntity(user);
    }


    @Override
    public UserDTO getEntityById (long id)
        throws Exception
    {
        User user = userPool.getEntityById(id);
       
    	return marshallUser(user);
    }


    @Override
    public List<User> getEntityList ()
        throws Exception
    {
        return userPool.getEntityList();
    }


    @Override
    public boolean deleteEntity (long id)
        throws Exception
    {
        return userPool.deleteEntity(id);
    }


    public boolean verifyUser (String userName, String password)
        throws Exception
    {
        String encryptpwd = password;
        // encryptpwd = CipherUtil.encrypt(encryptpwd, SALT);
        return userPool.verifyUser(userName, encryptpwd);
    }


    @Override
    public boolean updateEntity (User user)
        throws Exception
    {
        return userPool.updateEntity(user);
    }
    
	public UserDTO marshallUser(User anUser) {
		UserDTO userDTO = new UserDTO();
		userDTO.id = anUser.getId();

		userDTO.username = anUser.getUsername();

		userDTO.firstName = anUser.getFirstName();

		userDTO.lastName = anUser.getLastName();

		userDTO.email = anUser.getEmail();

		userDTO.phone = anUser.getPhone();

		userDTO.question = anUser.getQuestion().getId();

		userDTO.answer = anUser.getAnswer();
		return userDTO;
	}
}
