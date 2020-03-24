package com.gm.wj.controller;
import com.gm.wj.pojo.BookUserDTO;
import com.gm.wj.pojo.User;
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
    @PostMapping("/api/users")
    public List<User> user( @RequestBody BookUserDTO user){
//    public User user( @RequestParam("user") User user){
        return userService.selecUserMessagetByUserName (user.getUserName ());
    }
    @GetMapping("/api/updatePassword")
    public String updatePassword( @RequestBody User user ) {
        User user1 = userService.findByUserName (user.getUsername ());
        user.setPassword (user1.getPassword ());
        userService.addOrUpdate (user);
//        String message = "用户" + user.getUsername () + "状态更新成功";
//        return ResultFactory.buildSuccessResult (message);
        return user.getPassword ();
    }
}

