package com.company;

/**
 * @program: Leetcode
 * @description: 90min
 * @author: Mr.Wang
 * @create: 2024-01-20 19:20
 **/
public class MergeTwoSortedLists21E {



     public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode temp = new ListNode(-1);
            ListNode cur = temp;

            while (list1 != null && list2 != null) {
                if (list2.val <= list1.val) {
                    cur.next = list2;
                    list2 = list2.next;
                } else {
                    cur.next = list1;
                    list1 = list1.next;
                }
                cur=cur.next;
            }
            if(list1!=null){
                cur.next=list1;
            }
            if(list2!=null){
                cur.next=list2;
            }
            return temp.next;
        }

}
