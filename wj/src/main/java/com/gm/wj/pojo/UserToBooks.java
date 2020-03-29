package com.gm.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @author ZJR
 * @version 1.0
 * @date 2020/3/28 19:22
 */
@Entity
@Table(name = "user_to_books")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class UserToBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private int user_id;
    private String books_id;
    private int books_id_count;

    public int getBooks_id_count() {
        return books_id_count;
    }

    public void setBooks_id_count( int books_id_count ) {
        this.books_id_count = books_id_count;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id( int user_id ) {
        this.user_id = user_id;
    }

    public String getBooks_id() {
        return books_id;
    }

    public void setBooks_id( String books_id ) {
        this.books_id = books_id;
    }

}
