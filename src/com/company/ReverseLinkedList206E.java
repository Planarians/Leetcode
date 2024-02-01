package com.company;

/**
 * @program: Leetcode
 * @description: LinkedList Recursion
 * @author: Mr.Wang
 * @create: 2024-02-01 18:06
 **/
public class ReverseLinkedList206E {


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

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;

            if (head == null) {
                return head;
            }
            // if(head.next==null){
            // return head;
            // }

            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}
