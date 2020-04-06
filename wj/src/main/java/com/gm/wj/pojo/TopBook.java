package com.gm.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author ZJR
 * @version 1.0
 * @date 2020/3/9 9:56
 */
@Entity
@Table(name = "top_book")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class TopBook  implements Comparable<TopBook> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "book_id")
    private int bookId;

    @Column(name = "read_times")
    private int readTimes;

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
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
    @Override
    public int compareTo(TopBook topbook){
        return  topbook.getReadTimes () -this.readTimes;
    }
    public TopBook(){

    }

    public TopBook(int bookId, int readTimes) {
        this.bookId = bookId;
        this.readTimes = readTimes;
    }


}
