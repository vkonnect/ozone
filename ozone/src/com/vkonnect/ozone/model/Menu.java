package com.vkonnect.ozone.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "menu")
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

    @Column(name = "description")
    private String description;

    @Column(name = "icon")
    private byte[] icon;

    @Embedded
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


    public String getURL ()
    {
        return url;
    }


    public void setURL (String aURL)
    {
        this.url = aURL;
    }


    public String getDescription ()
    {
        return description;
    }

    public void setDescription  (String aDescription )
    {
        this.description = aDescription;
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
