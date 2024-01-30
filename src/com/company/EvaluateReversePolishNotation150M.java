package com.company;

import java.util.LinkedList;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-30 10:07
 **/
public class EvaluateReversePolishNotation150M {

        public int evalRPN(String[] tokens) {
            LinkedList<Integer> list=new LinkedList<>();
            int a=0;
            int b=0;
            int res=0;
            for(int i=0;i<tokens.length;i++){
                if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
                    if(tokens[i].equals("+")){
                        b=list.removeLast();
                        a=list.removeLast();
                        list.add(a+b);
                    }
                    if(tokens[i].equals("-")){
                        b=list.removeLast();
                        a=list.removeLast();
                        list.add(a-b);
                    }
                    if(tokens[i].equals("*")){
                        b=list.removeLast();
                        a=list.removeLast();
                        list.add(a*b);
                    }
                    if(tokens[i].equals("/")){
                        b=list.removeLast();
                        a=list.removeLast();
                        list.add(a/b);
                    }
                }else{
                    list.add(Integer.valueOf(tokens[i]));
                }
            }
            return list.removeLast();

    }



/**


 5
 13
 4


 */
}
