package com.company;

import java.util.HashMap;

/**
 * @program: Leetcode
 * @description:24min
 * @author: Mr.Wang
 * @create: 2024-01-12 14:33
 **/
public class RansomNote383E {
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map =new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            if(map.containsKey(magazine.charAt(i))){
                map.put(magazine.charAt(i),map.get(magazine.charAt(i))+1);
            }else {
                map.put(magazine.charAt(i),1);
            }
        }
        for(int i=0;i<ransomNote.length();i++){
            if(map.containsKey(ransomNote.charAt(i))){
                if(map.get(ransomNote.charAt(i))==1){
                    map.remove(ransomNote.charAt(i));
                }else {
                    map.put(ransomNote.charAt(i),map.get(ransomNote.charAt(i))-1);
                }
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String ransomNote="aadfdsf";
        String magazine="aabdfsd";

        System.out.println(canConstruct(ransomNote,magazine));
    }
}
