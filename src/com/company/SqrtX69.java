package com.company;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-25 16:28
 **/
public class SqrtX69 {
    public static int mySqrt1(int x) {
        if (x <= 1) {
            return x;
        }
        long[] squareRoots = new long[x + 1];
        for (int i = 0; i <= x; i++) {
            squareRoots[i] = (long) i * i;
        }

        int index = Arrays.binarySearch(squareRoots, x);

        if (index >= 0) {
            return index;
        } else {
            int insertionPoint = -index - 1;
            return insertionPoint - 1;
        }
    }


    public static int mySqrt(int x) {
        long lx = (long) x;
        long l = 0L;
        long r = (long) x;
        long mid = 0L;

        if (x == 1) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }

        while (l < r) {
            if (mid == (l + (r - l) / 2)) {
                mid = mid + 1;
            } else {
                mid = l + (r - l) / 2;
            }
            if (mid * mid == lx) {
                break;
            } else if ((mid * mid > lx) && ((mid - 1) * (mid - 1) < lx)) {
                mid = mid - 1L;
                break;
            } else if (mid * mid < lx) {
                l = mid;
            } else {
                r = mid;
            }
        }
        // if(l==r){
        //     mid=l;
        // }
        return (int) mid;
    }

    public static void main(String[] args) {

        System.out.println(mySqrt1(25));
    }
}
