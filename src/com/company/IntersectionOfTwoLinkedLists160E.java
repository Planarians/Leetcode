package com.company;

import java.util.HashSet;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-22 23:45
 **/
public class IntersectionOfTwoLinkedLists160E {


     // Definition for singly-linked list.
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
      val = x;
      next = null;
      }
      }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            set.add(headB);
            headB = headB.next;
        }
        return null;

    }

}
