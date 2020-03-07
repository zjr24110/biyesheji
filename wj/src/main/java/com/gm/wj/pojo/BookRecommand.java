package com.gm.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @author ZJR
 * @version 1.0
 * @date 2020/3/5 19:24
 */
@Entity
@Table(name = "book_recommand")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class BookRecommand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "book_condition")
    private String bookCondition;

    @Column(name = "result_books")
    private String resultBooks;

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getBookCondition() {
        return bookCondition;
    }

    public void setBookCondition( String bookCondition ) {
        this.bookCondition = bookCondition;
    }

    public String getResultBooks() {
        return resultBooks;
    }

    public void setResultBooks( String resultBooks ) {
        this.resultBooks = resultBooks;
    }
}
