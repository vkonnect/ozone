package com.vkonnect.ozone.dto;


import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MenuDTO
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    private long id;

    private String headerName;

    private String url;

    private String parentmenu;

    private String name;

    private int displayorder;

    private String description;

    private byte[] icon;

    public long getId ()
    {
        return id;
    }


    public void setId (long id)
    {
        this.id = id;
    }


    public String getHeaderName ()
    {
        return headerName;
    }


    public void setHeaderName (String aHeaderName)
    {
        this.headerName = aHeaderName;
    }


    public String getDescription ()
    {
        return description;
    }


    public void setDescription (String aDescription)
    {
        this.description = aDescription;
    }


    public String getUrl ()
    {
        return url;
    }


    public void setUrl (String url)
    {
        this.url = url;
    }


    public String getParentmenu ()
    {
        return parentmenu;
    }


    public void setParentmenu (String parentmenu)
    {
        this.parentmenu = parentmenu;
    }


    public String getName ()
    {
        return name;
    }


    public void setName (String name)
    {
        this.name = name;
    }


    public int getDisplayorder ()
    {
        return displayorder;
    }


    public void setDisplayorder (int displayorder)
    {
        this.displayorder = displayorder;
    }


    public byte[] getIcon ()
    {
        return icon;
    }


    public void setIcon (byte[] aIcon)
    {
        this.icon = aIcon;
    }
}
