package com.gm.wj.dao;

import com.gm.wj.pojo.Book;
import com.gm.wj.pojo.BookRecommand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author ZJR
 * @version 1.0
 * @date 2020/3/5 19:37
 */
public interface BookRecommandDAO extends JpaRepository<BookRecommand,Integer> {
    @Query(value = "select * from book_recommand where book_condition = ?1",nativeQuery = true)
    List<BookRecommand> findByBookCondition( String condition);
}
