package com.gm.wj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gm.wj.pojo.Category;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Evan
 * @date 2019/4
 */

public interface CategoryDAO extends JpaRepository<Category, Integer> {
//    @Query(value = "select * from category where name = ?1",nativeQuery = true)
//    Category findByMajorId(int name);
}
