//package com.gm.wj.util;
//import com.gm.wj.service.UserBookService;
//import com.gm.wj.service.UserToBooksService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RestController;
//import sun.security.util.Length;
//
//import java.util.*;
//import java.util.Map.Entry;
//
///**
// * 基于用户的协同过滤推荐算法实现
// A a b d
// B a c
// C b e
// D c d e
// * @author Administrator
// *
// */
//@RestController
//public class CF {
//    @Autowired
//    private UserBookService userBookService;
//    @Autowired
//    private UserToBooksService userToBooksService;
//    public void CF( int recommendUser,int M,List<Integer> UserItem,List<String> Bookids,int Length){
//        /**
//         * 输入用户-->物品条目  一个用户对应多个物品
//         * 用户ID	物品ID集合
//         *   A		a b d
//         *   B		a c
//         *   C		b e
//         *   D		c d e
//         */
//        System.out.println ("Input the total users number:");
//        UserBookService userBookService =new UserBookService ();
//        int N =M;
//        //00000000000000000000000.
//        //根据user_id获取有借阅记录的用户总数
//        int[][] sparseMatrix = new int[N][N];//建立用户稀疏矩阵，用于用户相似度计算【相似度矩阵】
//        Map<Integer, Integer> userItemLength = new HashMap<> ();//存储每一个用户对应的不同物品总数  eg: A 3
//        Map<Integer, Set<String>> itemUserCollection = new HashMap<> ();//建立物品到用户的倒排表 eg: a A B
//
//        Map<Integer, Integer> userID = new HashMap<> ();//辅助存储每一个用户的用户ID映射
//        Map<Integer, Integer> idUser = new HashMap<> ();//辅助存储每一个ID对应的用户映射
//        System.out.println ("Input user--items maping infermation:<eg:A a b d>");
//        //1.把所有的用户id取出
//        List<Integer> userItem = UserItem;
//        //1111111111111111111.userToBooksService.findAllUserId ();
//        //2.把所有用户阅读过的书籍id取出
//        List<String> bookids = Bookids;
//                //222222222222222222.userToBooksService.findAllBybookid();
//        Integer[] user_item = new Integer[userItem.size ()];
//        //3..把List<Integer> userItem转换为int[] user_item;
//        for (int i =  0; i<user_item.length;i++){
//            user_item[i] = userItem.get (i);
//        }
//        //4.把List<String> bookids 转化为Set<String> items
//        Object[] objects = bookids.toArray ();
//        String[] string = new String[bookids.size ()];
//        bookids.toArray (string);
//        String[] strings = bookids.toArray (new String[0]);
//        Set<String> items = new HashSet<String> (Arrays.asList (strings));//辅助存储物品集合
//
//
//
//
//        for (int i = 0; i < N; i++) {//依次处理N个用户 输入数据  以空格间隔
//            int length = Length;
//                    ////333333333333333);Length;=userToBooksService.findbooksidCount(user_item[i]);
//            userItemLength.put (user_item[0],length);//eg: A 3
//            userID.put (user_item[0], i);//用户ID与稀疏矩阵建立对应关系
//            idUser.put (i, user_item[0]);
//            //建立物品--用户倒排表
//            for (int j = 1; j < length; j++) {
//                if (items.contains (user_item[j])) {//如果已经包含对应的物品--用户映射，直接添加对应的用户
//                    itemUserCollection.get (user_item[j]).add (String.valueOf (user_item[0]));
//                } else {//否则创建对应物品--用户集合映射
//                    items.add (String.valueOf (user_item[j]));
//                    itemUserCollection.put (user_item[j], new HashSet<String> ());//创建物品--用户倒排关系
//                    itemUserCollection.get (user_item[j]).add (String.valueOf (user_item[0]));
//                }
//            }
//        }
//        System.out.println (itemUserCollection.toString ());
//        //计算相似度矩阵【稀疏】
//        Set<Entry<Integer, Set<String>>> entrySet = itemUserCollection.entrySet ();
//        Iterator<Entry<Integer, Set<String>>> iterator = entrySet.iterator ();
//        while (iterator.hasNext ()) {
//            Set<String> commonUsers = iterator.next ().getValue ();
//            for (String user_u : commonUsers) {
//                for (String user_v : commonUsers) {
//                    if (user_u.equals (user_v)) {
//                        continue;
//                    }
//                    sparseMatrix[userID.get (user_u)][userID.get (user_v)] += 1;//计算用户u与用户v都有正反馈的物品总数
//                }
//            }
//        }
//        System.out.println (userItemLength.toString ());
//        System.out.println ("Input the user for recommendation:<eg:A>");
////        Scanner scanner = new Scanner (System.in);
////        int recommendUser = scanner.nextInt ();
//        System.out.println (userID.get (recommendUser));
//        //计算用户之间的相似度【余弦相似性】
//        int recommendUserId = userID.get (recommendUser);
//        for (int j = 0; j < sparseMatrix.length; j++) {
//            if (j != recommendUserId) {
//                System.out.println (idUser.get (recommendUserId) + "--" + idUser.get (j) + "相似度:" + sparseMatrix[recommendUserId][j] / Math.sqrt (userItemLength.get (idUser.get (recommendUserId)) * userItemLength.get (idUser.get (j))));
//            }
//        }
//
//        //计算指定用户recommendUser的物品推荐度
//        for (String item : items) {//遍历每一件物品
//            Set<String> users = itemUserCollection.get (item);//得到购买当前物品的所有用户集合
//            if (!users.contains (recommendUser)) {//如果被推荐用户没有购买当前物品，则进行推荐度计算
//                double itemRecommendDegree = 0.0;
//                for (String user : users) {
//                    itemRecommendDegree += sparseMatrix[userID.get (recommendUser)][userID.get (user)] / Math.sqrt (userItemLength.get (recommendUser) * userItemLength.get (user));//推荐度计算
//                }
//                System.out.println ("The item " + item + " for " + recommendUser + "'s recommended degree:" + itemRecommendDegree);
//            }
//        }
//}
//
//}
