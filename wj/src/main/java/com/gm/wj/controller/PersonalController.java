package com.gm.wj.controller;

import com.gm.wj.dao.UserDAO;
import com.gm.wj.pojo.*;
import com.gm.wj.service.*;
import javafx.beans.property.ReadOnlyListProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.crypto.Aes128;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author ZJR
 * @version 1.0
 * @date 2020/3/3 9:43
 */
@RestController
public class PersonalController {
    @Autowired
    BookService bookService;
    @Autowired
    UserBookService userBookService;
    @Autowired
    UserService userService;
    @Autowired
    BookRecommandService bookRecommandService;
    @Autowired
    TopBookService topBookService;

    @PostMapping("/api/book")
    public List<Book> getMyBooks( @RequestBody BookUserDTO dto ){
        // 通过前端的请求消息（userName,bookID）来切入
        User user = userService.findByUserName (dto.getUserName ());
        List<UserBook> userBooks = userBookService.findByUserId(user.getId ());
        List<Integer> bookIdList = new ArrayList<> ();
        for (UserBook ub:userBooks){
            bookIdList.add (ub.getBookId ());
        }
        List<Book> books = bookService.findAllByBookId (bookIdList);
        return books;
    }
//////////////////////
    @PostMapping("api/topbook")
    public List<Book> geTopBooks() {
        List<Book> topbook = bookService.findAll();
            return topbook;
        }

///////////////////////////
    @PostMapping("/api/recommand")
    public List<Book> getRecommandBooks( @RequestBody BookUserDTO dto){
//    public List<Book> getRecommandBooks( @RequestParam("userName") String dto ){
        // 通过前端的请求消息（userName,bookID）来切入
//        User user = userService.findByUserName (dto.getUserName ());
        User user = userService.findByUserName (dto.getUserName ());
        List<UserBook> userBooks = userBookService.findByUserId(user.getId ());
        List<Integer> bookIdList = new ArrayList<> ();

        for (UserBook ub:userBooks){
            bookIdList.add (ub.getBookId ());
        }
        String condition = bookIdList.toString ();
        System.out.println (condition);
        List<BookRecommand> bookRecommandList = bookRecommandService.findRSbyCondition (condition);
        BookRecommand bookRecommand = new BookRecommand ();
        List<Book> books = new ArrayList<> ();
        if (bookRecommandList.size ()>0){
            bookRecommand = bookRecommandList.get (0);
            String bookIdListStr = bookRecommand.getResultBooks ();
            //
            String a = bookIdListStr.replace("[","").replace ("]","");
            String[] b = a.split(",");
            for (String bccc:b){
                System.out.println(bccc);
            }
            int[] c = new int[b.length];
            for(int i=0;i<b.length;i++){
                c[i] = Integer.parseInt(b[i]);
            }
            List<Integer> bookRecommander = new ArrayList<> ();
            for (int i = 0; i<c.length;i++){
                bookRecommander.add (c[i]);
            }
            //

            books = this.bookService.findAllByBookId (bookRecommander);
        }
        return books;
    }

}
