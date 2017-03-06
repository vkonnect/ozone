package com.vkonnect.ozone.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@Entity
@Table(name = "keyperson")
@JsonIgnoreProperties({"auditTrail"})
public class KeyPerson
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "position")
    private String position;

    @Column(name = "name")
    private String name;

    @Column(name = "emailaddress")
    private String emailaddress;

    @Column(name = "phone")
    private String phone;

    @ManyToOne
//    @Cache (usage=CacheConcurrencyStrategy.TRANSACTIONAL)
    @JoinColumn(name = "university_id")
    University university;
    
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


    public Auditable getAuditTrail ()
    {
        return auditTrail;
    }


    public void setAuditTrail (Auditable auditTrail)
    {
        this.auditTrail = auditTrail;
    }


    public University getUniversity() {
		return university;
	}


	public void setUniversity(University university) {
		this.university = university;
	}

}
