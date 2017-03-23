package com.vkonnect.ozone.dto;


import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UniversityDTO
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    private long id;

    private String name;

    private String code;

    private String profile;

    private byte[] logo;

    private String url;

    private String email;

    private String phone1;

    private String phone2;

    private String address;

    private String state;

    private String city;

    private String pincode;

    private byte[] map;

    private String remark;


    private String keyposition;

    private String kpname;

    private String kpemail;

    private String kpphone;

    public long getId ()
    {
        return id;
    }


    public void setId (long id)
    {
        this.id = id;
    }


    public String getRemark ()
    {
        return remark;
    }


    public void setRemark (String aRemark)
    {
        this.remark = aRemark;
    }


    public String getKeyposition ()
    {
        return keyposition;
    }


    public void setKeyposition (String keyposition)
    {
        this.keyposition = keyposition;
    }


    public String getKpname ()
    {
        return kpname;
    }


    public void setKpname (String kpname)
    {
        this.kpname = kpname;
    }


    public String getKpemail ()
    {
        return kpemail;
    }


    public void setKpemail (String kpemail)
    {
        this.kpemail = kpemail;
    }


    public String getKpphone ()
    {
        return kpphone;
    }


    public void setKpphone (String kpphone)
    {
        this.kpphone = kpphone;
    }


    public String getName ()
    {
        return name;
    }


    public void setName (String name)
    {
        this.name = name;
    }


    public String getCode ()
    {
        return code;
    }


    public void setCode (String code)
    {
        this.code = code;
    }


    public String getProfile ()
    {
        return profile;
    }


    public void setProfile (String profile)
    {
        this.profile = profile;
    }


    public byte[] getLogo ()
    {
        return logo;
    }


    public void setLogo (byte[] logo)
    {
        this.logo = logo;
    }


    public String getUrl ()
    {
        return url;
    }


    public void setUrl (String url)
    {
        this.url = url;
    }


    public String getEmail ()
    {
        return email;
    }


    public void setEmail (String email)
    {
        this.email = email;
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


    public String getAddress ()
    {
        return address;
    }


    public void setAddress (String address)
    {
        this.address = address;
    }


    public String getState ()
    {
        return state;
    }


    public void setState (String state)
    {
        this.state = state;
    }


    public String getCity ()
    {
        return city;
    }


    public void setCity (String city)
    {
        this.city = city;
    }


    public String getPincode ()
    {
        return pincode;
    }


    public void setPincode (String pincode)
    {
        this.pincode = pincode;
    }


    public byte[] getMap ()
    {
        return map;
    }


    public void setMap (byte[] map)
    {
        this.map = map;
    }
}
