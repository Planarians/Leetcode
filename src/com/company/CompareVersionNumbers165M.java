package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-12 00:29
 **/
public class CompareVersionNumbers165M {
    public static int compareVersion(String version1, String version2) {
        String [] s1s=version1.split("\\.");
        String [] s2s=version2.split("\\.");
        int max=Math.max(s1s.length,s2s.length);

        for(int i=0;i<Math.max(s1s.length,s2s.length);i++){
            int v1=0;
            int v2=0;
            if(i<=s1s.length-1&&!s1s[i].equals("")){
                v1=Integer.valueOf(s1s[i]);
            }
            if(i<=s2s.length-1&&!s2s[i].equals("")){
                v2=Integer.valueOf(s2s[i]);
            }
            if(v1>v2){
                return 1;
            }else if(v2>v1){
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String v1="7.5.2.4";
        String v2="7.5.3";
        System.out.println(compareVersion(v1,v2));
    }
}
