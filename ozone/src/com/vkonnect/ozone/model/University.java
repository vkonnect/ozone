package com.vkonnect.ozone.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@Entity
@Table(name = "university")
@JsonIgnoreProperties({"auditTrail"})
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
    Auditable auditTrail;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.E)
    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    //@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
    private List<KeyPerson> keyPersons;


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


    public Auditable getAuditTrail ()
    {
        return auditTrail;
    }


    public void setAuditTrail (Auditable auditTrail)
    {
        this.auditTrail = auditTrail;
    }


	public List<KeyPerson> getKeyPersons() {
		return keyPersons;
	}


	public void setKeyPersons(List<KeyPerson> keyPersons) {
		this.keyPersons = keyPersons;
	}



    // public Address getAddress ()
    // {
    // return address;
    // }
    //
    //
    // public void setAddress (Address address)
    // {
    // this.address = address;
    // }
}
