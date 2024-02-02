package com.company;

import java.util.HashMap;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-01 21:49
 **/
public class LinkedListCycleII142M {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode cur = head;
        int i = 0;

        HashMap<Integer, ListNode> map = new HashMap<>();
        if ((head == null) || (head.next == null)) {
            return null;
        }

        while (cur != null) {
            if (map.containsKey(System.identityHashCode(cur))) {
                return map.get(System.identityHashCode(cur));
            }
            map.put(System.identityHashCode(cur), cur);
            cur = cur.next;
        }

        return null;
    }
}
