package com.vkonnect.ozone.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vkonnect.ozone.dao.KeyPersonPool;
import com.vkonnect.ozone.model.KeyPerson;


public class keyPersonServiceImpl
    implements KeyPersonService
{

    @Autowired
    KeyPersonPool keyPersonPool;


    @Override
    public boolean addEntity (KeyPerson keyPerson)
        throws Exception
    {
        return keyPersonPool.addEntity(keyPerson);
    }


    @Override
    public KeyPerson getEntityById (long id)
        throws Exception
    {
        return keyPersonPool.getEntityById(id);
    }


    @Override
    public List<KeyPerson> getEntityList ()
        throws Exception
    {
        return keyPersonPool.getEntityList();
    }


    @Override
    public boolean deleteEntity (long id)
        throws Exception
    {
        return keyPersonPool.deleteEntity(id);
    }

}
