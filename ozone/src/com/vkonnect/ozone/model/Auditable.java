package com.vkonnect.ozone.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Embeddable
@Access(AccessType.PROPERTY)
public class Auditable
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date", insertable = false)
    private Date modifiedDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "is_active")
    private boolean isActive = true;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;


    public Date getCreatedDate ()
    {
        return createdDate;
    }


    public void setCreatedDate (Date createdDate)
    {
        this.createdDate = createdDate;
    }


    public Date getModifiedDate ()
    {
        return modifiedDate;
    }


    public void setModifiedDate (Date modifiedDate)
    {
        this.modifiedDate = modifiedDate;
    }


    public String getCreatedBy ()
    {
        return createdBy;
    }


    public void setCreatedBy (String createdBy)
    {
        this.createdBy = createdBy;
    }


    public String getModifiedBy ()
    {
        return modifiedBy;
    }


    public void setModifiedBy (String modifiedBy)
    {
        this.modifiedBy = modifiedBy;
    }


    public boolean isActive ()
    {
        return isActive;
    }


    public void setActive (boolean isActive)
    {
        this.isActive = isActive;
    }


    public boolean isDeleted ()
    {
        return isDeleted;
    }


    public void setDeleted (boolean isDeleted)
    {
        this.isDeleted = isDeleted;
    }


    @PrePersist
    protected void onCreate ()
    {
        modifiedDate = createdDate = new Date();
        createdBy = modifiedBy = "root";
    }


    @PreUpdate
    protected void onUpdate ()
    {
        modifiedDate = new Date();
        modifiedBy = "root";
    }
}
