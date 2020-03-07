package com.gm.wj.controller;

import com.alibaba.fastjson.JSON;
import com.gm.wj.pojo.BookRecommand;
import com.gm.wj.pojo.BookUserDTO;
import com.gm.wj.pojo.User;
import com.gm.wj.pojo.UserBook;
import com.gm.wj.result.Result;
import com.gm.wj.result.ResultCode;
import com.gm.wj.result.ResultFactory;
import com.gm.wj.service.BookRecommandService;
import com.gm.wj.service.UserBookService;
import com.gm.wj.service.UserService;
import com.gm.wj.util.AprioriMyself;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZJR
 * @version 1.0
 * @date 2020/2/29 13:05
 */
@RestController
public class UserBookController {

    @Autowired
    private UserBookService userBookService;

    @Autowired
    private UserService userService;
    @Autowired
    private BookRecommandService bookRecommandService;

    @PostMapping("/api/userBook/add")
    public Result addUserBook( @RequestBody BookUserDTO dto ){
//        UserBook userBook = JSON.parseObject (data,UserBook.class);
        // TODO: 2020/3/1 找出userid
        User user = userService.findByUserName (dto.getUserName ());
        System.out.println (user);
        UserBook userBook = new UserBook ();
        userBook.setUserId (user.getId ());
        userBook.setBookId (dto.getBookID ());
        userBookService.addUpdate(userBook);
        return ResultFactory.buildSuccessResult (null);
    }



    @PostMapping("api/apriori")
    public Result apriori(){
        List<Integer> userIdList = userBookService.userIdList();
        System.out.println (userIdList);
        List<List<String>> data = new ArrayList<> ();
        for (Integer uid:userIdList){
            List<String> bookIdList = userBookService.bookIdList(uid);
            data.add (bookIdList);
        }
        System.out.println (data);
        AprioriMyself.record = data;
        AprioriMyself.Apriori();//调用Apriori算法获得频繁项集
        System.out.println("频繁模式挖掘完毕。\n\n\n\n\n进行关联度挖掘，最小支持度百分比为："+AprioriMyself.MIN_SUPPROT+"  最小置信度为："+AprioriMyself.MIN_CONFIDENCE);

        List<BookRecommand> recommands = new ArrayList<> ();
        AprioriMyself.AssociationRulesMining(recommands);//挖掘关联规则
        if (recommands.size ()>0){
            bookRecommandService.insertList(recommands);
        }
        return ResultFactory.buildSuccessResult (recommands);
    }

}


