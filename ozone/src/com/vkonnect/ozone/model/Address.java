package com.vkonnect.ozone.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Address")
public class Address
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "address")
    private String address;
    
    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pincode")
    private int pincode;
    
    @Column(name = "country")
    private String country;
    
    @Column(name = "map")
    private byte[] map;
    
    @Column(name = "phone1")
    private String phone1;
    
    @Column(name = "phone2")
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
