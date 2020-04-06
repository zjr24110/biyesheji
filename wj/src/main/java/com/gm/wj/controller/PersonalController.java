package com.gm.wj.controller;
import com.gm.wj.pojo.*;
import com.gm.wj.service.*;
import org.elasticsearch.common.recycler.Recycler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

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
    @Autowired
    CategoryService categoryService;
    @Autowired
    BookToUsersService usersToUsersService;
    @Autowired
    BookToUsersService bookToUsersService;

    ///////////////////用户历史阅读的书籍
    @PostMapping("/api/book")   //用户的阅读记录
    public List<Book> getMyBooks( @RequestBody BookUserDTO dto ) {
        // 通过前端的请求消息（userName,bookID）来切入
        User user = userService.findByUserName (dto.getUserName ());
        List<UserBook> userBooks = userBookService.findByUserId (user.getId ());
        List<Integer> bookIdList = new ArrayList<> ();
        for (UserBook ub : userBooks) {
            bookIdList.add (ub.getBookId ());
        }
        List<Book> books = bookService.findAllByBookId (bookIdList);
        return books;
    }

    //////////////////////专业推荐书籍
    @PostMapping("api/majorRecommand")
    public List<Book> geTopBooks( @RequestBody BookUserDTO dto ) {
        User user = userService.findByUserName (dto.getUserName ());
//        Category category = categoryService.findCidByMajorId (user.getMajor ());
        List<Integer> BookId = userBookService.findBookIdbyCid (user.getMajor ());
        List<Book> RecommandMajorBooks = bookService.findAllByBookId (BookId);
        return RecommandMajorBooks;
    }
    /////////////////////排行榜书籍
    @PostMapping("api/topbook")
    public List<Book> getMajorBooks() {
        List<Book> topbook = bookService.findAll ();
        return topbook;
    }

    /////////////////////根据aprori关联规则算法推荐书籍
    @PostMapping("/api/recommand")
    public List<Book> getRecommandBooks( @RequestBody BookUserDTO dto ) {
//    public List<Book> getRecommandBooks( @RequestParam("userName") String dto ){
        // 通过前端的请求消息（userName,bookID）来切入
//        User user = userService.findByUserName (dto.getUserName ());
        User user = userService.findByUserName (dto.getUserName ());

        List<UserBook> userBooks = userBookService.findByUserId (user.getId ());
        List<Integer> bookIdList = new ArrayList<> ();

        for (UserBook ub : userBooks) {
            bookIdList.add (ub.getBookId ());
        }
        String condition = bookIdList.toString ();
//        System.out.println (condition);
        List<BookRecommand> bookRecommandList = bookRecommandService.findRSbyCondition (condition);
        BookRecommand bookRecommand = new BookRecommand ();
        List<Book> books = new ArrayList<> ();
        if (bookRecommandList.size () > 0) {
            bookRecommand = bookRecommandList.get (0);
            String bookIdListStr = bookRecommand.getResultBooks ();
            //把输出带有[]的格式的数据变为无[]的格式的数据
            String a = bookIdListStr.replace ("[", "").replace ("]", "");
            String[] b = a.split (",");
            for (String bccc : b) {
//                System.out.println(bccc);
            }
            int[] c = new int[b.length];
            for (int i = 0; i < b.length; i++) {
                c[i] = Integer.parseInt (b[i]);
            }
            List<Integer> bookRecommander = new ArrayList<> ();
            for (int i = 0; i < c.length; i++) {
                bookRecommander.add (c[i]);
            }
            //

            books = this.bookService.findAllByBookId (bookRecommander);
        }
        return books;
    }


    @PostMapping("/api/SecondRecommand")
//    用户正在浏览的bookid
//    1. 通过bookid去查询阅读过该商品的用户（用户列表）
//    2. 找到列表中每一个用户阅读过的书籍或历史浏览记录（书籍的id（书籍的列表））
//    3. 书籍集排序，获取排名靠前的书籍
    public List<Book> RecommandBooks(@RequestBody BookUserDTO dto) {  //   @RequestParam(value = "id") int id
        //1.读过该书的用户列表dto.getBookID ()
        List<Integer> usersId = userBookService.findUserIdsByBookId (dto.getBookID ());
        //将容器List里面的内容保存到数组中intArr
        int count = 0;
        int UsersIdSize = usersId.size ();
        Integer intArr[] = new Integer[UsersIdSize];//用户的个数
        for (int i = 0; i < UsersIdSize; i++) {
            intArr[count] = usersId.get (i);       //把所有用户的id存入数组中
            System.out.println (intArr[count]);
            count++;
        }
        System.out.println ("************************");
        ///////////////////////////////////////////////////////// 2. 存放各个用户对应的书籍List,下面for循环采用
        List<List<Integer>> arrayList = new ArrayList<> ();
        //  找到列表中每一个用户阅读过的书籍或历史浏览记录（书籍的id（书籍的列表））
        for (int i = 0; i < UsersIdSize; i++) {
            int k = intArr[i];//用户的id
            List<Integer> array = new ArrayList<> ();
            array = userBookService.bookIDList (k);//获取书籍List
            arrayList.add (array);
//            System.out.println (array[i]);
        }
        System.out.println ("***************************");
        ///////////////////////////////////////////////////////存储阅读过的书籍以及对应的被借阅次数
        List<TopBook> list = new ArrayList<TopBook> ();
        for (int i = 0;i<arrayList.size ();i++){
            for (Integer A : arrayList.get (i)) {
                int t = topBookService.findReadTimesByBookID (A);
                System.out.println ("用户"+i+"书籍ID:" + A + " " + "被阅读次数:" + t);
                TopBook topBook = new TopBook ();
                topBook.setBookId (A);
                topBook.setReadTimes (t);
                list.add (topBook);
            }
            System.out.println("###################");
        }
///////////////////////////////////////////////////////下面根据用户的书籍id去重
        list = list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(TopBook
                :: getBookId))), ArrayList::new));
         for (TopBook vv:list){
             System.out.println(vv.getReadTimes ());
         }
        ///////////////////////////////////////////////////////下面对去重后的Topbook按照阅读次数从高到低排序
        List<Integer> vv = new ArrayList<> ();
        Collections.sort(list);
        for(int i=0;i<list.size();i++)
        {
            TopBook topBook = list.get(i);
            System.out.println("书籍的id:"+topBook.getBookId ()+"书籍被借阅次数"+topBook.getReadTimes ());
        }
        ////////////////////////////////////////////////////////把list中排行前三的书籍输出
        List<Integer> vo = new ArrayList<>();
        for(int i=0;i<3;i++){
            TopBook topBook =  list.get(i);
            vo.add (topBook.getBookId ());
        }
        System.out.println(vo);
        /////////////////////////////////////////////////根据排行前三的书籍id，去找到对应的Book信息
        int Count = 0;
        int Size = vo.size ();
        Integer intBrr[] = new Integer[Size];//
        for (int i = 0; i < Size; i++) {
            intBrr[Count] = vo.get (i);       //把所有用户的id存入数组中
            System.out.println (intBrr[Count]);
            Count++;
        }
        /////////////////////////////////////////////////返回书籍集
        List<Book> books = new ArrayList<Book> ();
        for (int i = 0;i<3;i++){
            books.add (bookService.book (intBrr[i]));
        }
        return books;
      }
    }

