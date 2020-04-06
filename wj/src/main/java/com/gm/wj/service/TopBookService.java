package com.gm.wj.service;

import com.gm.wj.dao.BookDAO;
import com.gm.wj.dao.TopBookDAO;
import com.gm.wj.dao.UserBookDAO;
import com.gm.wj.pojo.TopBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZJR
 * @version 1.0
 * @date 2020/3/9 14:55
 */
@Service
public class TopBookService {
    @Autowired
    UserBookDAO userBookDAO;
    @Autowired
    BookDAO bookDAO;
    @Autowired
    TopBookDAO topBookDAO;

    public void addTopBook( TopBook topBook ){
        List<TopBook> results = topBookDAO.findAllByBookId (topBook.getBookId ());
        if (results.size ()>0){
            TopBook topBookNew = results.get (0);
            topBookNew.setReadTimes (topBookNew.getReadTimes ()+1);
            topBookDAO.save (topBookNew);
        }else {
            topBook.setReadTimes (1);
            topBookDAO.save (topBook);
        }

    }

    public List<TopBook> findAll() {
        return topBookDAO.findAll();
    }

    public List<TopBook> findAllA() {
        return topBookDAO.findAllA();
    }

    public int findReadTimesByBookID(int bookid) {
        return topBookDAO.findReadTimeByBookId (bookid);
    }
}
