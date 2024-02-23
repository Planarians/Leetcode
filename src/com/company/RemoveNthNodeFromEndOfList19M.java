package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-23 12:29
 **/
public class RemoveNthNodeFromEndOfList19M {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
        public static ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode l=head;
            ListNode r=head;
            ListNode cur=head;
            ListNode res=new ListNode(-1);
            ListNode pre=res;
            ListNode next=head;
            res.next=head;

            if(head==null||head.next==null){
                return null;
            }

            for(int i=0;i<n;i++){
                r=r.next;
                if(r==null&&i!=n-1){
                    return null;
                }
            }

            while(r!=null){
                next=l.next;
                pre=l;
                l=next;
                r=r.next;
            }

            pre.next=l.next;

            return res.next;
    }

    public static void main(String[] args) {
        ListNode node2=new ListNode(2);
        ListNode node=new ListNode(1,node2);
        System.out.println(removeNthFromEnd(node,2));
    }
}
