package com.gm.wj.pojo;

/**
 * @author ZJR
 * @version 1.0
 * @date 2020/3/1 19:09
 */
public class BookUserDTO {

    private String userName;

    private Integer bookID;

    public String getUserName() {
        return userName;
    }

    public void setUserName( String userName ) {
        this.userName = userName;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID( Integer bookID ) {
        this.bookID = bookID;
    }
}
