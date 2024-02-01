package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-01 21:03
 **/
public class ReverseLinkedListII92M {


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


    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = head;
        ListNode res = node;
        ListNode pre = null;
        ListNode next = null;
        ListNode leftNode = null;
        ListNode leftLeftNode = null;
        ListNode rightRightNode = null;

        int index = 1;

        if (head == null || left == right) {
            return head;
        }

        // if(n>1){
        // for(int i=1;i=<left;i++){
        // node=node.next;

        // }

        // }

        while (node != null) {
            if (index == left) {
                leftNode = node;
                ListNode x = node;
                // left==1;
                if (pre == null) {
                    ListNode[] reverseListAndRight = reverseList(x, right - left + 1);
                    leftNode.next = reverseListAndRight[1];
                    return reverseListAndRight[0];
                } else {
                    leftLeftNode = pre;
                    ListNode[] reverseListAndRight = reverseList(x, right - left + 1);
                    leftLeftNode.next = reverseListAndRight[0];
                    leftNode.next = reverseListAndRight[1];
                    return res;
                }
            }
            pre = node;
            next = node.next;
            node = next;
            index++;
        }

        return res;
    }

    public static ListNode[] reverseList(ListNode head, int size) {

        ListNode cur = head;
        ListNode res = head;
        ListNode next = head;
        ListNode pre = null;
        ListNode[] reverseListAndRight = new ListNode[2];

        if (head == null) {
            return null;
        }

        while (cur != null && size != 0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

            size--;
        }
        reverseListAndRight[0] = pre;
        reverseListAndRight[1] = next;


        return reverseListAndRight;
    }


    public static void main(String[] args) {

        // 输入: head = [1,2,3,4,5], left = 2, right = 4
        int[] values = {3, 5};
        ListNode head = createLinkedList(values);
        printLinkedList(head);

        int left = 1;
        int right =2;

        ListNode result = reverseBetween(head, left, right);

        printLinkedList(result);
    }


    // 创建链表的方法
    private static ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    // 打印链表的方法
    private static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

}
