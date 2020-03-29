package com.gm.wj.dao;


import com.gm.wj.pojo.UserToBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author ZJR
 * @version 1.0
 * @date 2020/3/28 19:58
 */
public interface UserToBooksDAO extends JpaRepository<UserToBooks,Integer> {
    @Query(value = "select distinct user_id from user_to_books ",nativeQuery = true)
    List<Integer> findAllBy();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update user_to_books as p set p.books_id =?1 where p.user_id =?2",nativeQuery = true)
    void updatebooksIdByUserId( String booksId,  int userId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update user_to_books as p set p.books_id_count =?1 where p.user_id =?2",nativeQuery = true)
    void updatebooksCountIdByUserId( int BooksIdCount, int userId );

}
