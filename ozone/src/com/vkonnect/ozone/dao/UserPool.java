package com.vkonnect.ozone.dao;


import java.util.List;

import com.vkonnect.ozone.model.User;


public interface UserPool
{

    public boolean addEntity (User user)
        throws Exception;


    public User getEntityById (long id)
        throws Exception;


    public List<User> getEntityList ()
        throws Exception;


    public boolean deleteEntity (long id)
        throws Exception;


    public boolean verifyUser (String userName, String password)
        throws Exception;


    public boolean updateEntity (User user)
        throws Exception;
}
