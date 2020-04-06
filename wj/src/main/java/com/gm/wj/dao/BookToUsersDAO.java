package com.gm.wj.dao;

import com.gm.wj.pojo.BookToUsers;
import com.gm.wj.pojo.UserToBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
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

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update book_to_users as p set p.users_id =?1 where p.book_id =?2",nativeQuery = true)
    void updatebooksCountIdByUserId(String usersId,int BookId);


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update book_to_users as p set p.users_id_count =?1 where p.book_id =?2",nativeQuery = true)
    void updateUsersCountIdByBookId( int usersIdCount, int bookId );

    //查找该本书籍对应的读者的总数
    @Query(value = "select  users_id_count from book_to_users where book_id =?1",nativeQuery = true)
    int findUsersIdCountByBookId(int bookId);
}
