package com.gm.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @author ZJR
 * @version 1.0
 * @date 2020/3/28 19:23
 */
@Entity
@Table(name = "book_to_users")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class BookToUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private int book_id;
    private String users_id;
    private int users_id_count;

    public int getUsers_id_count() {
        return users_id_count;
    }

    public void setUsers_id_count( int users_id_count ) {
        this.users_id_count = users_id_count;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id( int book_id ) {
        this.book_id = book_id;
    }

    public String getUsers_id() {
        return users_id;
    }

    public void setUsers_id( String users_id ) {
        this.users_id = users_id;
    }
}
