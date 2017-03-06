package com.vkonnect.ozone.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "hint_question")
public class HintQuestion
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "question")
    private String question;

    @Column(name = "remark")
    private String remark;

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


    public String getQuestion ()
    {
        return question;
    }


    public void setQuestion (String aQuestion)
    {
        this.question = aQuestion;
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

}
