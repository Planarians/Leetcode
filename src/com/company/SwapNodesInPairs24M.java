package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-03-03 11:17
 **/
public class SwapNodesInPairs24M {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode res=new ListNode(0,head);
            ListNode pre=res;
            ListNode next=head;
            ListNode cur=head;
            ListNode nextNext=head;
            if(head==null){
                return null;
            }

            while(nextNext!=null&&nextNext.next!=null){
                next=cur.next;
                nextNext=next.next;
                pre.next=next;
                pre=cur;
                cur.next=nextNext;
                next.next=cur;
                cur=cur.next;
            }



            return res.next;
        }
    }
}
