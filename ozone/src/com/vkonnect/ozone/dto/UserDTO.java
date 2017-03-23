package com.vkonnect.ozone.dto;


import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "password"})
public class UserDTO
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    public long id;

    public String username;

    @JsonIgnore
    private String password;

    public String firstName;

    public String lastName;

    public String email;

    public String phone;

    public long question;

    public String answer;

    public Date lastLogin;

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

   


    public long getQuestion() {
		return question;
	}


	public void setQuestion(long question) {
		this.question = question;
	}


	public Date getLastLogin() {
		return lastLogin;
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
