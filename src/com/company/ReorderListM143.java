package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-20 12:39
 **/
public class ReorderListM143 {
      public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    class Solution {
        public void reorderList(ListNode head) {
            ListNode slow=head;
            ListNode fast=head.next;
            ListNode next=head;
            ListNode pre=null;
            ListNode second=null;
            ListNode cur=head;
            if(head==null||head.next==null){
                return;
            }
            while(fast!=null&&fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            // if(fast==null){//odd;
            //     odd=
            // }

            second=slow.next;
            slow.next=null;
            while(second!=null){
                next=second.next;
                second.next=pre;
                pre=second;
                second=next;
            }

            second=pre;//where wrong because now second =null, need to be pre


            ListNode fcur=head;
            ListNode scur=second;
            ListNode fnext=head;
            ListNode snext=second;

            while(fcur!=null&&scur!=null){
                fnext=fcur.next;
                snext=scur.next;
                fcur.next=scur;
                scur.next=fnext;
                fcur=fnext;
                scur=snext;
            }


        }
    }
}
