package com.vkonnect.ozone.dto;


import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class HintQuestionDTO
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    private long id;

    private String question;

    private String remark;

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
}
