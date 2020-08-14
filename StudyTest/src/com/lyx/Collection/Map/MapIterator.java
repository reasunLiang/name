package com.lyx.Collection.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Package: com.lyx.Collection.Map
 * @ClassName: MapIterator
 * @Author: LYX
 * @CreateTime: 2020/7/31 17:17
 * @Description:
 */
public class MapIterator {
    public static void main(String[] args) {
//        demo1();
        Map<String,Integer> map = new HashMap<>();
        map.put("lyx",12);
        map.put("wa",19);
        map.put("wo",69);
        map.put("wo",69);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> map1 : entries){
            Map.Entry<String,Integer> entry = map1;
            String key = entry.getKey();            //从entry中提取key
            Integer value = entry.getValue();       //从entry中提取value
            System.out.println("KEY = " + key + ",  VALUE : " + value);
        }
    }

    private static void demo1() {
        Map<String,Integer> map = new HashMap<>();
        map.put("lyx",12);
        map.put("wa",19);
        map.put("wo",69);
        map.put("wo",69);
        Set<String> strings = map.keySet();
        System.out.println(strings);
        //通过迭代器迭代
//        Iterator<String> it = strings.iterator();
//        while (it.hasNext()){
//            System.out.println(map.get(it.next()));
//        }
        //通过增强for循环迭代
        for (String key : map.keySet()){
            System.out.println(key + "=" + map.get(key));
        }
    }
}
