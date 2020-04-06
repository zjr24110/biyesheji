package com.gm.wj.controller;
import com.gm.wj.pojo.*;
import com.gm.wj.result.Result;
import com.gm.wj.result.ResultFactory;
import com.gm.wj.service.*;
import com.gm.wj.util.AprioriMyself;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private  TopBookService topBookService;
    @Autowired
    private BookRecommandService bookRecommandService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserToBooksService userToBooksService;
    @Autowired
    private  BookToUsersService bookToUsersService;

    @PostMapping("/api/userBook/add")
    public Result addUserBook( @RequestBody BookUserDTO dto ){
//        UserBook userBook = JSON.parseObject (data,UserBook.class);
        // TODO: 2020/3/1 找出userid
        User user = userService.findByUserName (dto.getUserName ());
//        Category category = categoryService.findCidByMajorName (user.getMajor ());
        Book bookv = bookService.findCidByBookId (dto.getBookID ());
        Category category = bookv.getCategory ();
        System.out.println (user);
        UserBook userBook = new UserBook ();
        userBook.setUserId (user.getId ());
        userBook.setBookId (dto.getBookID ());
        userBook.setCid(category.getId ());
        //排行前八的书对应的次数的增加
        userBookService.addUpdate(userBook);
        TopBook topBook =new TopBook ();
        topBook.setBookId (dto.getBookID ());
        //图书表的阅读次数的增加
        topBookService.addTopBook (topBook);
        Book book = new Book ();
        book.setId (dto.getBookID ());
        bookService.addTimes(book);

        //1.记录一个用户所读过的书籍
        UserToBooks userToBooks =new UserToBooks ();
        userToBooks.setUser_id (user.getId ());
        List<Integer> AllUserId = userToBooksService.findAllUserId ();//查找user_to_books中所有的用户id
        List<String> AllUserBooksId = userBookService.BooksIdList(user.getId ());//根据传入的userID查找出该用户看过的所有书籍的id
        String alluserBooksId = AllUserBooksId.toString ();
        String a = alluserBooksId.replace("[","").replace ("]","").replace(",","");
        System.out.println(alluserBooksId);
        ////////////////////////////把用户ID存入user_to_books中，并且不能重复
        if(!AllUserId.contains(user.getId ()))
        {
            userToBooksService.addOrUpdate (userToBooks);
        }
        userToBooksService.updatebooksIdByUserId(a,user.getId ());
        int booksIdCount =userBookService.CountBooksId(user.getId ());
        userToBooksService.updatebooksIdCountByUserId (booksIdCount,user.getId ());

        //2.一本书籍以及其所对应的所有用户
        List<BookToUsers> list = new ArrayList();
        List<Integer> bookIdList = bookService.bookIdList();
        List<Integer> OldbookIdList = bookToUsersService.bookIdList();
        for (int i = 0;i<bookIdList.size ();i++){
                  BookToUsers bookToUsers = new BookToUsers ();
                  //用最新user_book表与旧表对比，把新表中的新数据存入，更新
              if (!OldbookIdList.contains (bookIdList.get (i))) {
                  bookToUsers.setBook_id (bookIdList.get (i));
                  bookToUsersService.addOrUpdate (bookToUsers);
              }
            }
            //存入书籍对应的所有用户id
        for (int i = 0;i<bookIdList.size ();i++){
            List<Integer> UsersId = userBookService.findUserIdsByBookId(bookIdList.get (i));
            String b = UsersId.toString ();
            String c = b.replace("[","").replace ("]","").replace(",","");
//            System.out.println(c);
            bookToUsersService.updateusersIdCountBybookId (c,bookIdList.get (i));

        }
           int usersIdCount = userBookService.CountUsersId(dto.getBookID ());
           System.out.println(usersIdCount);
           bookToUsersService.updateUsersIdCountByBookId (usersIdCount,dto.getBookID ());
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


