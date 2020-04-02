package com.gm.wj.dao;

import com.gm.wj.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evan
 * @date 2019/4
 */

public interface UserDAO extends JpaRepository<User,Integer> {
    User findByUsername(String username);

    User getByUsernameAndPassword(String username,String password);

    @Query(value = "select new User(u.id,u.username,u.name,u.phone,u.major,u.enabled,u.profession) from User u")
    List<User> list();

/////////////////////动手
    @Query(value = "select * from user where username = ?1",nativeQuery = true )
    List<User> selecUserMessagetByUserName( String username );



    //////////////getAllUsersId
    @Query(value = "select distinct id from user",nativeQuery = true )
    ArrayList<User> getAllUsers();
//
//    @Query(value = "update user INNER JOIN category ON user.major = category.id SET user.profession = category.name",nativeQuery = true )
//    void updateStateBy(String username);
}
