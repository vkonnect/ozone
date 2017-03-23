package com.vkonnect.ozone.dto;


import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class KeyPersonDTO
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    private long id;

    private String position;

    private String name;

    private String emailaddress;

    private String phone;


    public long getId ()
    {
        return id;
    }


    public void setId (long id)
    {
        this.id = id;
    }


    public String getPosition ()
    {
        return position;
    }


    public void setPosition (String position)
    {
        this.position = position;
    }


    public String getName ()
    {
        return name;
    }


    public void setName (String name)
    {
        this.name = name;
    }


    public String getEmailaddress ()
    {
        return emailaddress;
    }


    public void setEmailaddress (String emailaddress)
    {
        this.emailaddress = emailaddress;
    }


    public String getPhone ()
    {
        return phone;
    }


    public void setPhone (String phone)
    {
        this.phone = phone;
    }

    public static long getSerialversionuid ()
    {
        return serialVersionUID;
    }


}
