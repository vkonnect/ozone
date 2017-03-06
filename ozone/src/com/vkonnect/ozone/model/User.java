package com.vkonnect.ozone.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;


@Entity
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "loginpassword",""})
public class User
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "passwordkey")
    private String passwordkey;

    @Column(name = "first_name")
    @Field(index=Index.YES, analyze=Analyze.YES)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    private HintQuestion question;

    @Column(name = "answer")
    private String answer;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastlogin")
    private Date lastLogin;


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


    public String getUsername ()
    {
        return username;
    }


    public void setUsername (String username)
    {
        this.username = username;
    }


    public String getPassword ()
    {
        return password;
    }


    public void setPassword (String password)
    {
        this.password = password;
    }


    public String getPasswordkey ()
    {
        return passwordkey;
    }


    public void setPasswordkey (String passwordkey)
    {
        this.passwordkey = passwordkey;
    }


    public String getFirstName ()
    {
        return firstName;
    }


    public void setFirstName (String firstName)
    {
        this.firstName = firstName;
    }


    public String getLastName ()
    {
        return lastName;
    }


    public void setLastName (String lastName)
    {
        this.lastName = lastName;
    }


    public String getEmail ()
    {
        return email;
    }


    public void setEmail (String email)
    {
        this.email = email;
    }


    public String getPhone ()
    {
        return phone;
    }


    public void setPhone (String phone)
    {
        this.phone = phone;
    }


    // public Date getLastLogin() {
    // return lastLogin;
    // }

    public void setLastLogin (Date lastLogin)
    {
        this.lastLogin = lastLogin;
    }


     public Auditable getAuditTrail() {
     return auditTrail;
     }
    
     public void setAuditTrail(Auditable auditTrail) {
     this.auditTrail = auditTrail;
     }

    public HintQuestion getQuestion ()
    {
        return question;
    }


    public void setQuestion (HintQuestion question)
    {
        this.question = question;
    }


    public String getAnswer ()
    {
        return answer;
    }


    public void setAnswer (String answer)
    {
        this.answer = answer;
    }

}
