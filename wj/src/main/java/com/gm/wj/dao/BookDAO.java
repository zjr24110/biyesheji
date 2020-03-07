package com.gm.wj.dao;

import com.gm.wj.pojo.Book;
import com.gm.wj.pojo.Category;
import com.gm.wj.pojo.User;
import com.gm.wj.pojo.UserBook;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Evan
 * @date 2019/4
 */

public interface BookDAO extends JpaRepository<Book,Integer> {
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);

    List<Book> findByIdIn( List<Integer> bookIdList, Sort sort );
}
