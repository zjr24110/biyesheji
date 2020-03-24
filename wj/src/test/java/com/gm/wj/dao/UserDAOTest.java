package com.gm.wj.dao;
import com.gm.wj.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

/**
 * @author ZJR
 * @version 1.0
 * @date 2020/3/24 19:13
 */
@SpringBootTest
public class UserDAOTest {

    @Autowired
    private UserService userService;

    @Test
    public void findAll(){
        System.out.println(userService.list());

    }

}