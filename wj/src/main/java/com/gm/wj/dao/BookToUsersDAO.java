package com.gm.wj.dao;

import com.gm.wj.pojo.BookToUsers;
import com.gm.wj.pojo.UserToBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author ZJR
 * @version 1.0
 * @date 2020/3/29 21:15
 */
public interface BookToUsersDAO extends JpaRepository<BookToUsers,Integer> {
    //记录所有书籍的id
    @Query(value = "select distinct book_id from book_to_users",nativeQuery = true)
    List<Integer> findAllById();
}
