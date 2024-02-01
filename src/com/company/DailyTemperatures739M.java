package com.company;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-31 16:47
 **/
public class DailyTemperatures739M {

    public static int[] dailyTemperatures(int[] temperatures) {
        int [] output=new int[temperatures.length];
        Stack<Integer> stack=new Stack<>();

        if(temperatures.length==1){
            output[0]=1;
            return output;
        }

        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty()&&temperatures[stack.peek()]<temperatures[i]){
                output[stack.peek()]=i-stack.pop();
            }
            stack.push(i);
        }

        return output;
    }

        public static int[] dailyTemperatures0(int[] temperatures) {
            int [] output=new int[temperatures.length];
            int [] sort=Arrays.copyOf(temperatures,temperatures.length);
            Arrays.sort(sort);
            int max=sort[sort.length-1];

            for(int i=0;i<temperatures.length;i++){
                if(temperatures[i]==max){
                    output[i]=0;
                }else{
                    for(int j=i+1;j<temperatures.length;j++){
                        if(temperatures[j]>temperatures[i]){
                            output[i]=j-i;
                            break;
                        }
                    }
                }
            }

            return output;
        }

    public static void main(String[] args) {
        int [] temperatures={73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

}

/**
73 74 75 71 69 72 76 73
 73x 74x


 5 4 3 2 1 3
 */