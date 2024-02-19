package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-18 01:58
 **/
public class LastStoneWeight1046E {

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            queue.offer(stone);
        }

        while (queue.size() >= 2) {
            int st = queue.poll();
            int nd = queue.poll();
            if (st > nd) {
                queue.offer(st - nd);
            }
        }
        if (queue.isEmpty()) {
            return 0;
        }

        return queue.peek();
    }
        public static int lastStoneWeight0(int[] stones) {

            // ArrayList<Integer> list = new ArrayList<>(Arrays.asList(stones));
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < stones.length; i++) {
                list.add(stones[i]);
            }
            if (stones.length == 1) {
                return stones[0];
            }

            Collections.sort(list, Collections.reverseOrder());
            while (list.size() >= 2) {
                if (list.get(0) == list.get(1)) {
                    if(list.size()==2){
                        return 0;
                    }
                    list.remove(0);
                    list.remove(0);
                } else {
                    list.set(0, list.get(0) - list.get(1));
                    // list.get(0)=list.get(0)-list.get(1);
                    list.remove(1);
                }
                Collections.sort(list, Collections.reverseOrder());
            }
            return list.get(0);
    }

    public static void main(String[] args) {
        int [] stones={10,4,2,10};
        System.out.println(lastStoneWeight(stones));
    }
}
