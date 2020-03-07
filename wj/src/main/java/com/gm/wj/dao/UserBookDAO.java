package com.gm.wj.dao;

import com.gm.wj.pojo.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author ZJR
 * @version 1.0
 * @date 2020/2/29 12:54
 */
public interface UserBookDAO extends JpaRepository<UserBook,Integer> {

    @Query(value = "select * from user_book as u where u.user_id=?1 and u.book_id=?2",nativeQuery = true)
    List<UserBook> findByUserIdBookId( int userId, int bookId );

    @Query(value = "select * from user_book as u where u.user_id=?1",nativeQuery = true)
    List<UserBook> findByUserId( int userId );

    @Query(value = "select distinct user_id from user_book",nativeQuery = true)
    List<Integer> userIdList();

    @Query(value = "select book_id from user_book where user_id = ?1",nativeQuery = true)
    List<Integer> bookIdList( Integer uid );
}
