package com.gm.wj.service;

import com.gm.wj.dao.BookRecommandDAO;
import com.gm.wj.pojo.Book;
import com.gm.wj.pojo.BookRecommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZJR
 * @version 1.0
 * @date 2020/3/5 19:35
 */
@Service
public class BookRecommandService {
    @Autowired
    BookRecommandDAO bookRecommandDAO;

    public void insertList( List<BookRecommand> recommands ) {
        for (BookRecommand bookRecommand : recommands){

            bookRecommandDAO.save (bookRecommand);
        }
    }

    public List<BookRecommand> findRSbyCondition( String condition) {
        return bookRecommandDAO.findByBookCondition (condition);
    }
}
