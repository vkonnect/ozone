package com.vkonnect.ozone.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vkonnect.ozone.dao.UserPool;
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
    public User getEntityById (long id)
        throws Exception
    {
        return userPool.getEntityById(id);
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
}
