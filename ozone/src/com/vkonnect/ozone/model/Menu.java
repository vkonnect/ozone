package com.vkonnect.ozone.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@Entity
@Table(name = "menu")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","auditTrail"})
public class Menu
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "header_name")
    private String headerName;

    @Column(name = "url")
    private String url;

    @Column(name = "parent_menu")
    private String parentmenu;

    @Column(name = "name")
    private String name;

    @Column(name = "display_order")
    private int displayorder;


    @Column(name = "description")
    private String description;

    @Column(name = "icon")
    private byte[] icon;

    @Embedded
    @JsonIgnore
    Auditable auditTrail;


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


    public Auditable getAuditTrail ()
    {
        return auditTrail;
    }


    public void setAuditTrail (Auditable auditTrail)
    {
        this.auditTrail = auditTrail;
    }

}
