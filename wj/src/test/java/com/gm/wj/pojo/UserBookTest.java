package com.gm.wj.pojo;

import antlr.StringUtils;
import com.alibaba.fastjson.JSON;
import com.mysql.cj.jdbc.integration.jboss.ExtendedMysqlExceptionSorter;
import org.junit.Test;
import org.springframework.boot.test.json.JsonbTester;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author ZJR
 * @version 1.0
 * @date 2020/2/29 13:31
 */
public class UserBookTest {

    @Test
    public void test(){
        UserBook userBook = new UserBook ();
        userBook.setId (5);
        userBook.setUserId (6);
        userBook.setBookId (2);
        userBook.setReadTimes (3);

        String data = JSON.toJSONString (userBook);
        System.out.println (data);
    }

    @Test
    public void strTest(){
        String bookid = "[22,55,66,88]";
        String a = bookid.replace("[","").replace ("]","");
        //去除[]
        String[] b = a.split(",");
        System.out.println(b[0]);
        //去除”,"
        System.out.println(a);
        int[] ints = new int[b.length];
        //创建数组长度与字符串数组长度一样的整型数组ints
        for(int i=0;i<b.length;i++){
            ints[i] = Integer.parseInt(b[i]);
        }
        //把b字符串数组转换为int型数组

        List<Integer> bookIdList = new ArrayList();
        for (int i = 0; i<ints.length;i++){
            bookIdList.add (ints[i]);
        }

        System.out.println(bookIdList);
        String c = bookIdList.toString ();
        System.out.println (c);
    }

}