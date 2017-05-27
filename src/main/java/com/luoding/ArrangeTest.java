package com.luoding;

import java.util.*;

/**
 * author: ding.luo
 * time: 17-2-23 上午11:27
 */
public class ArrangeTest {

    public static void main(String[] args) {

        Map<String, List<String>> listMap = new HashMap<>();
        Random random = new Random(100);
        int r1 = random.nextInt(10);
        for (int i = 0; i < r1; i++) {
            String key = (char)('a' + i) + "";
            int r2 = random.nextInt(5);
            List<String> list = new ArrayList<>();
            for (int j = 0; j < r2; j++) {
                list.add(key+j);
            }
            listMap.put(key,list);
        }
        System.out.println(listMap.toString());
        List<String> keys = new ArrayList<>();
        keys.addAll(listMap.keySet());
        List<List<String>> allList = new ArrayList<>();
        listMap.put(keys.get(keys.size()-1),new ArrayList<String>());
        arrange(listMap, 0, new ArrayList<String>(), allList, keys);
        System.out.println(allList);
        System.out.println(allList.size());
    }

    public static void arrange(Map<String,List<String>> listMap,int index,
                               List<String> list,List<List<String>>allList,List<String> keys){

        if(index>=keys.size()){
            allList.add(list);
            return;
        }
        for(int i=index;i<keys.size();i++){
            String key = keys.get(i);
            List<String> ls = listMap.get(key);
            if(ls.isEmpty()){
                arrange(listMap, i+1, list, allList, keys);
            }else{
                for(String str:ls){
                    List<String> l = new ArrayList<>();
                    l.addAll(list);
                    l.add(str);
                    arrange(listMap, i+1, l, allList, keys);
                }
            }
            break;
        }
    }
}
