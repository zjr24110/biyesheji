package com.gm.wj.dao;

import com.gm.wj.pojo.Book;
import com.gm.wj.pojo.Category;
import com.gm.wj.pojo.User;
import com.gm.wj.pojo.UserBook;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evan
 * @date 2019/4
 */

public interface BookDAO extends JpaRepository<Book,Integer> {
    List<Book> findAllByCategory(Category category);

    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
//    @Query(value = "select * from user_book,book where book.id  =  user_book.id ",nativeQuery = true)
    List<Book> findByIdIn( List<Integer> bookIdList, Sort sort );

//     List<Book> findByTimes( List<Integer> bookIdList, Sort sort );
    @Query(value = "select * from book order by readtimes desc limit 0,8",nativeQuery = true)
    List<Book> findAll();

    @Query(value = "select * from book where id = ?1",nativeQuery = true)
    List<Book> findAllById( int Id );

    @Query(value = "select * from book where id = ?1",nativeQuery = true)
    Book findById( int Id );

    //记录所有书籍的id
    @Query(value = "select distinct id from book",nativeQuery = true)
    List<Integer> findAllById();

    //getAllbooksId
    @Query(value = "select distinct id from book",nativeQuery = true)
    ArrayList<Book> getAllBooks();

}
