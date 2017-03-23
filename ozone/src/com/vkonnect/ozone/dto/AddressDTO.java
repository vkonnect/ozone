package com.vkonnect.ozone.dto;


import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AddressDTO
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    private long id;

    private String address;
    
    private String city;

    private String state;

    private int pincode;
    
    private String country;
    
    private byte[] map;
    
    private String phone1;
    
    private String phone2;

    public long getId ()
    {
        return id;
    }

    public void setId (long id)
    {
        this.id = id;
    }

    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public int getPincode ()
    {
        return pincode;
    }

    public void setPincode (int pincode)
    {
        this.pincode = pincode;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    public byte[] getMap ()
    {
        return map;
    }

    public void setMap (byte[] map)
    {
        this.map = map;
    }

    public String getPhone1 ()
    {
        return phone1;
    }

    public void setPhone1 (String phone1)
    {
        this.phone1 = phone1;
    }

    public String getPhone2 ()
    {
        return phone2;
    }

    public void setPhone2 (String phone2)
    {
        this.phone2 = phone2;
    }
}
