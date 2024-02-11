package com.company;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-07 12:31
 **/
public class TrappingRainWater42 {
    public static int trap2(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int sum = 0;
        int k = 0;
        int maxLeft = 0;
        int maxRight = 0;

        while (l < r) {
            maxLeft = Math.max(maxLeft, height[l]);
            maxRight = Math.max(maxRight, height[r]);
            if (maxRight >= maxLeft) {
                k = maxLeft - height[l];
                if (k > 0) {
                    sum += k;
                }
                l++;
                continue;
            } else {
                k = maxRight - height[r];
                if (k > 0) {
                    sum += k;
                }
                r--;
                continue;
            }
        }
        return sum;
    }
    public static int trap(int[] height) {
        int l = -1;
        int r = -1;
        int sum = 0;
        int k = 0;
        int[] minLR = new int[height.length];
        int[] sort = Arrays.copyOf(height, height.length);
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        Arrays.sort(sort);
        int max = sort[sort.length - 1];

        for (int i = 0; i < height.length; i++) {

            if (i + 1 < height.length) {
                maxLeft[i + 1] = Math.max(maxLeft[i], height[i]);
            } else {
                maxLeft[i] = maxLeft[i - 1];
            }

        }
        for (int i = height.length - 1; i >= 0; i--) {
            if (i - 1 >= 0) {
                maxRight[i - 1] = Math.max(maxRight[i], height[i]);
            } else {
                maxRight[i] = maxRight[i + 1];
            }
        }
        for (int i = 0; i < height.length; i++) {
            minLR[i] = Math.min(maxLeft[i], maxRight[i]);
            k = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (k > 0) {
                sum += k;
            }
        }


        return sum;

    }

    public static int trap0(int[] height) {
        int l = -1;
        int r = -1;
        int sum = 0;
        int[] sort = Arrays.copyOf(height, height.length);
        Arrays.sort(sort);
        int max = sort[sort.length - 1];

        for (int i = 1; i <= max; i++) {
            l = -1;
            r = -1;
            for (int j = 0; j < height.length; j++) {
                if (l == -1 && height[j] >= i) {
                    l = j;
                    continue;
                }
                if (l != -1) {
                    if (r == -1) {
                        if (height[j] >= i) {
                            r = j;
                            sum += r - l - 1;
                            l = r;
                            r = -1;
                        } else {
                            continue;
                        }
                    }

                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(height));
    }

}
