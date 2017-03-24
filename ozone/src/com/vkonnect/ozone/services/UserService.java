package com.vkonnect.ozone.services;


import java.util.List;

import com.vkonnect.ozone.dto.UserDTO;
import com.vkonnect.ozone.model.User;


public interface UserService
{
    public boolean addEntity (User user)
        throws Exception;


    public UserDTO getEntityById (long id)
        throws Exception;


    public List<UserDTO> getEntityList ()
        throws Exception;


    public boolean deleteEntity (long id)
        throws Exception;


    public boolean verifyUser (String userName, String password)
        throws Exception;


    public boolean updateEntity (User user)
        throws Exception;
    
    public boolean updateUserPassword(String userName, long hintQuestionId, String hintAnswer, String newPassword) throws Exception;
}
