package egovframework.user.service;

/**
 * @Class Name : UserVO.java
 * @Description : User VO class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-04-16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class UserVO extends UserDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** id */
    private int id;
    
    /** userId */
    private java.lang.String userid;
    
    /** userPass */
    private java.lang.String userpass;
    
    /** userName */
    private java.lang.String username;
    
    /** userContent */
    private java.lang.String usercontent;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public java.lang.String getUserid() {
        return this.userid;
    }
    
    public void setUserid(java.lang.String userid) {
        this.userid = userid;
    }
    
    public java.lang.String getUserpass() {
        return this.userpass;
    }
    
    public void setUserpass(java.lang.String userpass) {
        this.userpass = userpass;
    }
    
    public java.lang.String getUsername() {
        return this.username;
    }
    
    public void setUsername(java.lang.String username) {
        this.username = username;
    }
    
    public java.lang.String getUsercontent() {
        return this.usercontent;
    }
    
    public void setUsercontent(java.lang.String usercontent) {
        this.usercontent = usercontent;
    }
    
}
