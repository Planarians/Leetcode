package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-20 16:53
 **/
public class AddTwoNumbers2M {
    public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode res = new ListNode(1);
            ListNode output = res;
            int add = 0;
            int sum = 0;
            if (l1 == null && l2 == null) {
                return null;
            }
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }

            while (l1 != null && l2 != null) {
                sum = l1.val + l2.val + add;
                ListNode node = new ListNode(sum % 10);
                res.next = node;
                add = sum / 10;
                res = res.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (l2 != null) {
                l1 = l2;
            }
            if (l1 != null) {
                while (l1 != null) {
                    sum = l1.val + add;
                    ListNode node = new ListNode(sum % 10);
                    res.next = node;
                    add = sum / 10;
                    res = res.next;
                    l1 = l1.next;
                }
            }
            if (add > 0) {
                ListNode node = new ListNode(1);
                res.next = node;
            }

            return output.next;

        }
    }
}
