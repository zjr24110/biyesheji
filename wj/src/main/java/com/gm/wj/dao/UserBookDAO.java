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

    @Query(value = "select * from user_book as u where u.book_id=?1",nativeQuery = true)
    List<UserBook> findByBookId( int bookId );

    @Query(value = "select * from user_book as u where u.user_id=?1",nativeQuery = true)
    List<UserBook> findByUserId( int userId );

    @Query(value = "select distinct user_id from user_book",nativeQuery = true)
    List<Integer> findDistinctByUserId();

    @Query(value = "select book_id from user_book where user_id = ?1",nativeQuery = true)
    List<Integer> bookIdList( Integer uid );

    @Query(value = "select DISTINCT book_id from user_book where cid = ?1",nativeQuery = true)
    List<Integer> selectBookIdByCid( int cid );
      //查找有阅读记录的用户的总数
    @Query(value = "select COUNT(DISTINCT user_id) FROM user_book ",nativeQuery = true)
    int countByUserId();
    //通过user_id查找出用户看过的书籍id，并且不能重复
    @Query(value = "select DISTINCT book_id from user_book where user_id = ?1",nativeQuery = true)
    List<String> booksIdList(int userId);
    //查找有阅读记录的用户的书籍总数
    @Query(value = "select COUNT(DISTINCT book_id) FROM user_book where user_id=?1 ",nativeQuery = true)
    int countByBooksId(int userId);
}
