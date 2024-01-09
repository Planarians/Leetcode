package com.company;

import java.util.*;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2023-12-16 01:51
 **/
public class MergeTwoSortedLists21 {


    public static ArrayList<Integer> mergeTwoLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> outputList = new ArrayList<>();
        for (Integer integer : list1) {
            outputList.add(integer);
        }
        for (Integer integer : list2) {
            outputList.add(integer);
        }
        Collections.sort(outputList);


        return outputList;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 4));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 3, 4));
        ArrayList<Integer> output = mergeTwoLists(list1,list2);
        System.out.println(output);

    }
}
