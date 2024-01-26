package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-25 22:19
 **/
public class CliimbiingStairs70E {
        public static int climbStairs(int n) {
            int output=0;
            int countOf2=n/2;
            for(int i=0;i<=countOf2;i++){
                output+=combination(n-i*2+i,i);
            }
            return output;
        }

        public static int combination(int n,int r){
            if(r==0) {
                return 1;
            }
            return factorial(n)/(factorial(r)*factorial(n-r));
        }

        public static int factorial(int n){
            int k=1;
            if(n==0) {
                return 1;
            }
            for(int i=1;i<=n;i++){
                k*=i;
            }
            return k;
        }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
        System.out.println(combination(3,1));
    }
}
