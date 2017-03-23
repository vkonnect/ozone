package com.vkonnect.ozone.dto;


import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MenuHeaderDTO
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    private long id;

    private String name;


    private String description;

    public long getId ()
    {
        return id;
    }


    public void setId (long id)
    {
        this.id = id;
    }


    public String getName ()
    {
        return name;
    }


    public void setName (String aName)
    {
        this.name = aName;
    }


    public String getDescription ()
    {
        return description;
    }


    public void setDescription (String aDescription)
    {
        this.description = aDescription;
    }

}
