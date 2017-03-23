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
@Table(name = "menu_header")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","auditTrail"})
public class MenuHeader
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "name")
    private String name;


    @Column(name = "description")
    private String description;

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


    public Auditable getAuditTrail ()
    {
        return auditTrail;
    }


    public void setAuditTrail (Auditable auditTrail)
    {
        this.auditTrail = auditTrail;
    }

}
