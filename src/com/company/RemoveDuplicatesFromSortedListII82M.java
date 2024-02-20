package com.company;

import java.util.HashSet;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-20 01:49
 **/
public class RemoveDuplicatesFromSortedListII82M {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates1(ListNode head) {
        ListNode res = new ListNode(101);
        res.next = head;
        ListNode cur = head;
        ListNode pre = res;
        ListNode next = head;
        int k = 102;
        if (head == null || head.next == null) {
            return head;
        }
        while (cur != null) {
            next = cur.next;
            if (next != null) {
                if (cur.val == next.val) {
                    k = cur.val;
                }
            }
            if (k == cur.val) {
                pre.next = next;
                cur.next = null;
                cur = next;
            } else {
                pre = cur;
                cur = next;
            }
        }
        return res.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(101);
        res.next = head;
        ListNode cur = head;
        ListNode pre = res;
        ListNode next = head;
        HashSet<Integer> set = new HashSet<>();
        if (head == null || head.next == null) {
            return head;
        }

        while (cur != null) {
            next = cur.next;
            if (next != null) {
                if (cur.val == next.val) {
                    set.add(cur.val);
                }
            }
            if (set.contains(cur.val)) {
                pre.next = next;
                cur.next = null;
                cur = next;
            } else {
                pre = cur;
                cur = next;
            }
        }
        return res.next;

    }
}
