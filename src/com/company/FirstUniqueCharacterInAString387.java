package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-05 19:11
 **/
public class FirstUniqueCharacterInAString387 {

        public int firstUniqChar(String s) {
            char c=' ';
            int res=-1;
            int times=0;
            LinkedHashMap<Character,Integer> map=new LinkedHashMap<>();
            HashMap<Character,Integer> map1=new HashMap<>();
            for(int i=0;i<s.length();i++){
                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),-1);
                }else{
                    map.put(s.charAt(i),1);
                    map1.put(s.charAt(i),i);
                }
            }

            for(Map.Entry<Character,Integer> entry:map.entrySet()){
                if(entry.getValue()==1){
                    return map1.get(entry.getKey());
                }
            }

            return -1;


        }

}
