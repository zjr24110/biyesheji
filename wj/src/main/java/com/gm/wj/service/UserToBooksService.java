package com.gm.wj.service;

import com.gm.wj.dao.UserToBooksDAO;
import com.gm.wj.pojo.UserToBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZJR
 * @version 1.0
 * @date 2020/3/28 20:00
 */
@Service
public class UserToBooksService {
    @Autowired
    UserToBooksDAO userToBooksDAO;



    public void addOrUpdate(UserToBooks userToBooks) {
            userToBooksDAO.save (userToBooks);
        }

        public List<Integer> findAllUserId(){
        return userToBooksDAO.findAllBy();
        }

        public void updatebooksIdByUserId(String booksId,  int userId){
            userToBooksDAO.updatebooksIdByUserId (booksId,userId);
        }

        public void updatebooksIdCountByUserId(int booksIdcount,  int userId){
        userToBooksDAO.updatebooksCountIdByUserId (booksIdcount,userId);
    }


}

