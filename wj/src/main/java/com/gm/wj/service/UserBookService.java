package com.gm.wj.service;

import com.gm.wj.dao.BookDAO;
import com.gm.wj.dao.TopBookDAO;
import com.gm.wj.dao.UserBookDAO;
import com.gm.wj.pojo.Book;
import com.gm.wj.pojo.TopBook;
import com.gm.wj.pojo.UserBook;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.tools.Klist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZJR
 * @version 1.0
 * @date 2020/2/29 13:17
 */
@Service
public class UserBookService {

    @Autowired
    UserBookDAO userBookDAO;
    @Autowired
    BookDAO bookDAO;


    public void addUpdate( UserBook userBook ) {
        // TODO: 2020/2/29 首先根据userid和bookid查UserBook是否存在这条记录
        List<UserBook> results = userBookDAO.findByUserIdBookId(userBook.getUserId (),userBook.getBookId ());
        if (results.size ()>0){
            UserBook userBookNew = results.get (0);
            userBookNew.setReadTimes (userBookNew.getReadTimes ()+1);
            userBookDAO.save (userBookNew);
        }else {
            userBook.setReadTimes (1);
            userBookDAO.save (userBook);
        }
    }


    public List<UserBook> findByUserId( int userId ) {
        return userBookDAO.findByUserId(userId);
    }

    public List<Integer> userIdList() {
        return userBookDAO.userIdList();
    }

    public List<String> bookIdList( Integer uid ) {
        List<Integer> intUidList = userBookDAO.bookIdList(uid);
        List<String> userIdList = new ArrayList<> ();
        for (Integer idu:intUidList){
            userIdList.add (String.valueOf (idu));
        }
        return userIdList;
    }

    public List<UserBook> findByBookId(int bookId)
    {return userBookDAO.findByBookId(bookId);}

}
