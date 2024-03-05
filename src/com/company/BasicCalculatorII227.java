package com.company;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-03-05 13:25
 **/
public class BasicCalculatorII227 {

    class Solution2 {//by other
        public int calculate(String s) {
            Stack<Integer> st = new Stack<>();

            int num = 0;
            char operator = '+';

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                }

                if (isOperator(c) || i == s.length() - 1) {
                    if (operator == '+') {
                        st.push(num);
                    } else if (operator == '-') {
                        st.push(-num);
                    } else if (operator == '*') {
                        st.push(st.pop() * num);
                    } else if (operator == '/') {
                        st.push(st.pop() / num);
                    }
                    num = 0;
                    operator = c;
                }
            }
            int ans = 0;
            while (!st.isEmpty()) {
                ans += st.pop();
            }
            return ans;
        }

        private boolean isOperator(char c) {
            return c == '+' || c == '-' || c == '*' || c == '/';
        }
    }

    // TC: O(n), SC: O(n)
    class Solution {//by me
        public int calculate(String s) {
            LinkedList<String> stack=new LinkedList<>();
            char c='0';
            boolean multiply=false,divide=false;
            int n1=0,n2=0;
            int res=0;
            for(int i=0;i<s.length();i++){
                c=s.charAt(i);
                if(c=='+'||c=='-'){
                    stack.push(String.valueOf(c));
                }else if(c=='*'||c=='/'){
                    if(c=='*'){
                        multiply=true;
                    }else{
                        divide=true;
                    }
                }else if(c==' '){

                }else if(multiply||divide){
                    n1=Integer.valueOf(stack.pop());
                    n2=c-'0';
                    for(int j=i+1;j<s.length();j++){
                        if(s.charAt(j)>='0'&&s.charAt(j)<='9'){
                            n2=n2*10+s.charAt(j)-'0';
                        }else{
                            i=j-1;
                            break;
                        }
                    }
                    if(multiply==true){
                        stack.push(String.valueOf(n1*n2));
                        multiply=false;
                    }else{
                        stack.push(String.valueOf(n1/n2));
                        divide=false;
                    }

                }else{//c=0-9
                    n1=c-'0';
                    for(int j=i+1;j<s.length();j++){
                        if(s.charAt(j)>='0'&&s.charAt(j)<='9'){
                            n1=n1*10+s.charAt(j)-'0';
                        }else{
                            i=j-1;
                            break;
                        }
                    }
                    stack.push(String.valueOf(n1));
                }
            }
            // n1=Integer.valueOf(stack.pop());
            while(!stack.isEmpty()){
                String str=stack.peek();
                if(str.equals("-")){
                    n1=-n1;
                    res+=n1;
                    n1=0;
                }else if(str.equals("+")){
                    res+=n1;
                    n1=0;
                }else{
                    n1=Integer.valueOf(str);
                }
                stack.pop();
            }
            if(n1!=0){
                res+=n1;
            }
            return res;
        }
    }
}
