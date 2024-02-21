package com.company;

import java.util.LinkedList;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-21 14:04
 **/
public class DecodeString394 {
        public static String decodeString(String s) {
            LinkedList<String> stack = new LinkedList<>();
            int k = 0;
            String ks="";
            boolean f = false;
            String es = "";
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                    stack.push(String.valueOf(s.charAt(i)));
                    continue;
                }

                if (s.charAt(i) == ']') {
                    while(stack.size()>=1) {
                        if(!f) {
                            if (!stack.peek().equals("[")) {
                                res = stack.pop() + res;
                            } else {
                                f = true;
                                stack.pop();
                                continue;
                            }
                        }
                        if (f) {
                            if (stack.peek().charAt(0) <= '9' && stack.peek().charAt(0) >= '0') {
                                if(stack.size()==1){
                                    ks=stack.pop()+ks;
                                    for (int i1 = 0; i1 < Integer.valueOf(ks); i1++) {
                                        stack.push(res);
                                    }
                                    f = false;
                                    res = "";
                                    ks = "";
                                    break;
                                }else{
                                    ks=stack.pop()+ks;
                                }
                            } else {
                                for (int i1 = 0; i1 < Integer.valueOf(ks); i1++) {
                                    stack.push(res);
                                }
                                f = false;
                                res = "";
                                ks = "";
                                break;
                            }
                        }
                    }

                } else {
                    stack.push(String.valueOf(s.charAt(i)));
                    continue;
                }
            }
            while(stack.size()>0){
                res=stack.pop()+res;
            }
            return res;
        }

    public static void main(String[] args) {
        String s="3[a2[c]]";
        System.out.println(decodeString(s));
    }
}
