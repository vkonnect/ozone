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
@Table(name = "university")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","auditTrail"})
public class University
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "profile")
    private String profile;

    @Column(name = "logo")
    private byte[] logo;

    @Column(name = "url")
    private String url;

    @Column(name = "email")
    private String email;

    @Column(name = "phone1")
    private String phone1;

    @Column(name = "phone2")
    private String phone2;

    @Column(name = "address")
    private String address;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "map")
    private byte[] map;

    @Column(name = "remark")
    private String remark;

    @Embedded
    @JsonIgnore
    Auditable auditTrail;

    @Column(name = "keyposition")
    private String keyposition;

    @Column(name = "kpname")
    private String kpname;

    @Column(name = "kpemail")
    private String kpemail;

    @Column(name = "kpphone")
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


    public Auditable getAuditTrail ()
    {
        return auditTrail;
    }


    public void setAuditTrail (Auditable auditTrail)
    {
        this.auditTrail = auditTrail;
    }

}
