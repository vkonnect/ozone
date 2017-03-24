package com.vkonnect.ozone.dto;


/**
 * The model for accepting user credentials
 *  
 */
public class ResetPasswordDTO
{
    /**
     * The field to hold username
     */
    public String username;
    
    /**
     *  Hint Question Id;
     */
    public int hintquestionid;
    
    /**
     * Answer of Hint Question
     */
    public String answer;

    /**
     * The field to hold new password
     */
    public String newpassword;
}
