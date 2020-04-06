package com.gm.wj.service;

import cn.hutool.poi.excel.WorkbookUtil;
import com.gm.wj.dao.BookDAO;
import com.gm.wj.pojo.Book;
import com.gm.wj.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Evan
 * @date 2019/4
 */

@Service
public class BookService {
    @Autowired
    BookDAO bookDAO;
    @Autowired
    CategoryService categoryService;

    public List<Book> list() {
        Sort sort = new Sort (Sort.Direction.DESC, "id");
        return bookDAO.findAll (sort);
    }

    public void addOrUpdate( Book book ) {
        bookDAO.save (book);
    }

    public void deleteById( int id ) {
        bookDAO.deleteById (id);
    }

    public List<Book> listByCategory( int cid ) {
        Category category = categoryService.get (cid);
        Sort sort = new Sort (Sort.Direction.DESC, "id");
        return bookDAO.findAllByCategory (category);
    }

    public List<Book> Search( String keywords ) {
        return bookDAO.findAllByTitleLikeOrAuthorLike ('%' + keywords + '%', '%' + keywords + '%');
    }

    public List<Book> findAllByBookId( List<Integer> bookIdList ) {
        Sort sort = new Sort (Sort.Direction.DESC, "id");
        return bookDAO.findByIdIn (bookIdList,sort);}

//////////////////////////////////////
//        public List<Book> findAllByTimes( List<Integer> bookIdList ) {
//            Sort sort = new Sort (Sort.Direction.DESC, "readtimes");
//            return bookDAO.findByTimes(bookIdList,sort); }
///////////////////////////////////////


     public List<Book> findAll() {
        return bookDAO.findAll();
      }


    public void addTimes( Book book ) {
        List<Book> results = bookDAO.findAllById (book.getId ());
        if (results.size ()>0){
            Book BookNew = results.get (0);
            BookNew.setRead_times (BookNew.getRead_times ()+1);
            bookDAO.save(BookNew);
        }else {
            book.setRead_times (1);
            bookDAO.save (book);
        }
    }

    public Book findCidByBookId(int id) {
        return bookDAO.findById (id);
    }

    //////////////所有书籍的id
    public List< Integer> bookIdList() {
        return bookDAO.findAllById ();
    }

    //////////////返回这本书籍的信息
    public Book book(int bookid){
        return bookDAO.findOneBookByID(bookid);
    }

}
