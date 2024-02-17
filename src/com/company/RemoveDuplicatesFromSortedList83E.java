package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-17 22:32
 **/
public class RemoveDuplicatesFromSortedList83E {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode node = head;
        ListNode pre = null;
        ListNode next = null;

        if (head == null || head.next == null) {
            return head;
        }

        while (cur != null) {
            next = cur.next;
            if (pre != null) {
                if (cur.val == pre.val) {
                    pre.next = cur.next;
                    cur.next = null;
                }else{
                    pre = cur;
                }
            }else{
                pre = cur;
            }
            cur = next;
        }
        return node;
    }

    public static class ListNode {
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
//wrong beacuse if input is {1,1,1} then will return {1,1} because in the middle pre will became the wrong
    public static ListNode deleteDuplicates0(ListNode head) {
        ListNode cur = head;
        ListNode node = head;
        ListNode pre = null;
        ListNode next = null;

        if (head == null || head.next == null) {
            return head;
        }

        while (cur != null) {
            next = cur.next;
            if (pre != null) {
                if (cur.val == pre.val) {
                    pre.next = cur.next;
                    cur.next = null;
                }
            }
            pre = cur;
            cur = next;
        }

        return node;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(1);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(1, node2);
        deleteDuplicates(node1);
    }
}



