package com.lyx.Collection.test;

import com.lyx.Collection.TreeSet.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

/**
 * @Package: com.lyx.Collection.test
 * @ClassName: Poker
 * @Author: LYX
 * @CreateTime: 2020/8/6 15:21
 * @Description:斗地主发牌模拟，牌没有顺序
 * 分析：
 * 1：获取一套完整的扑克牌
 * 2：洗牌：
 * 3：发牌
 * 4：看牌
 */
public class Poker {
    public static void main(String[] args) {
//        demo1();

        //泛型固定下边界


    }

    private static void demo1() {
        //获取扑克牌
        String[] num = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] color = {"红桃","方块","梅花","黑桃"};
        ArrayList<String> arr = new ArrayList<>();
        for (String s: color ) {
            for ( String s1: num ) {
                arr.add(s + s1);
            }
        }
        arr.add("大鬼");
        arr.add("小鬼");
        //洗牌
        Collections.shuffle(arr);
        ArrayList<String> user1 = new ArrayList<>();
        ArrayList<String> user2 = new ArrayList<>();
        ArrayList<String> user3 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();
        Date time = new Date();
        Random r = new Random(time.getTime());
        int d = r.nextInt(51) + 3;

        for(int i = 0 ;i < arr.size() ; i++ ){
            if(i < 3 ){
                dipai.add(arr.get(i));
            }else if (i % 3 == 0){
                if (i == d) user1.addAll(dipai);
                user1.add(arr.get(i));
            }else if (i % 3 == 1){
                if (i == d) user2.addAll(dipai);
                user2.add(arr.get(i));
            }else{
                if (i == d) user3.addAll(dipai);
                user3.add(arr.get(i));
            }
        }
        Collections.sort(user1);
        Collections.sort(user2);
        Collections.sort(user3);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
    }
}
