package com.gm.wj.dao;
import com.gm.wj.pojo.TopBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**admin_role
 * @author ZJR
 * @version 1.0
 * @date 2020/3/9 14:03
 */
public interface TopBookDAO extends JpaRepository<TopBook,Integer> {
    @Query(value = "select * from top_book order by read_times desc limit 0,8",nativeQuery = true)
    List<TopBook> findAll();

    @Query(value = "select * from top_book where book_id = ?1",nativeQuery = true)
    List<TopBook> findAllByBookId( int bookId );

    @Query(value = "select * from top_book ",nativeQuery = true)
    List<TopBook> findAllA( );

    @Query(value = "select read_times from top_book where book_id = ?1",nativeQuery = true)
    int findReadTimeByBookId( int bookid );
        }
