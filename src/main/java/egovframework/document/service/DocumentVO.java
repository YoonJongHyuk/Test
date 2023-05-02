package egovframework.document.service;

/**
 * @Class Name : DocumentVO.java
 * @Description : Document VO class
 * @Modification Information
 *
 * @author stillthere
 * @since 2023-04-28
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class DocumentVO extends DocumentDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** id */
    private int id;
    
    /** title */
    private java.lang.String title;
    
    /** content */
    private java.lang.String content;
    
    /** time */
    private java.lang.String time;
    
    /** level */
    private java.lang.String level;
    
    /** star */
    private int star;
    
    /** appendix */
    private java.lang.String appendix;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public java.lang.String getTitle() {
        return this.title;
    }
    
    public void setTitle(java.lang.String title) {
        this.title = title;
    }
    
    public java.lang.String getContent() {
        return this.content;
    }
    
    public void setContent(java.lang.String content) {
        this.content = content;
    }
    
    public java.lang.String getTime() {
        return this.time;
    }
    
    public void setTime(java.lang.String time) {
        this.time = time;
    }
    
    public java.lang.String getLevel() {
        return this.level;
    }
    
    public void setLevel(java.lang.String level) {
        this.level = level;
    }
    
    public int getStar() {
        return this.star;
    }
    
    public void setStar(int star) {
        this.star = star;
    }
    
    public java.lang.String getAppendix() {
        return this.appendix;
    }
    
    public void setAppendix(java.lang.String appendix) {
        this.level = appendix;
    }
    
}
