package com.gm.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

/**
 * @author ZJR
 * @version 1.0
 * @date 2020/2/29 12:46
 */
@Entity
@Table(name = "user_book")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class UserBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "user_id")
    private int userId;

    @Column(name = "book_id")
    private int bookId;

    @Column(name = "read_times")
    private int readTimes;
    @Column(name = "cid")
    private int cid;


    public int getCid() {
        return cid;
    }

    public void setCid( int cid ) {
        this.cid = cid;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId( int userId ) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId( int bookId ) {
        this.bookId = bookId;
    }

    public int getReadTimes() {
        return readTimes;
    }

    public void setReadTimes( int readTimes ) {
        this.readTimes = readTimes;
    }
}
