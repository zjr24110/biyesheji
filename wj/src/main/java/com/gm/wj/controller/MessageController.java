package com.gm.wj.controller;
import com.gm.wj.pojo.BookUserDTO;
import com.gm.wj.pojo.Category;
import com.gm.wj.pojo.User;
import com.gm.wj.result.Result;
import com.gm.wj.result.ResultFactory;
import com.gm.wj.service.CategoryService;
import com.gm.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ZJR
 * @version 1.0
 * @date 2020/3/23 21:08
 */
@RestController
public class MessageController {
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;
//    @PostMapping("/api/users")
//    public List<User> user( @RequestBody BookUserDTO user){
//    public User user( @RequestParam("user") User user){
//        User user2 = userService.findProfessionByMajor (user.getUserName ());
//        userService.addOrUpdate (user2);
//        return userService.selecUserMessagetByUserName (user.getUserName ());
//    }
    @PostMapping("/api/updatePassword")
    public Result updatePassword( @RequestBody User user ) {
        User user1 = userService.findByUserName (user.getUsername ());
        user1.setPassword (user.getPassword ());
        userService.addOrUpdate (user1);
        String message = "用户" + user.getUsername () + "状态更新成功";
        return ResultFactory.buildSuccessResult (message);
//        return user.getPassword ();
    }


    //获取当前登录用户的信息
    @PostMapping("/api/users")
    public List<User> haha( @RequestBody BookUserDTO user){
        User user2 = userService.findByUserName (user.getUserName ());
        Category category2 = categoryService.get (user2.getMajor ());
        user2.setProfession (category2.getName ());
        userService.addOrUpdate (user2);
        return userService.selecUserMessagetByUserName (user.getUserName ());
    }
}

