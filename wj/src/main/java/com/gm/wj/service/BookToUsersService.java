package com.gm.wj.service;

import com.gm.wj.dao.BookToUsersDAO;
import com.gm.wj.pojo.BookToUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZJR
 * @version 1.0
 * @date 2020/3/29 21:19
 */
@Service
public class BookToUsersService {
    @Autowired
    BookToUsersDAO bookToUsersDAO;
    public void addOrUpdate(BookToUsers bookToUsers) {
        bookToUsersDAO.save (bookToUsers);
    }

    public List< Integer> bookIdList() {
        return bookToUsersDAO.findAllById();
    }
}
