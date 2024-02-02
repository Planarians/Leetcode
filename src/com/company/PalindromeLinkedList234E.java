package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-02 16:36
 **/
public class PalindromeLinkedList234E {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public boolean isPalindrome(ListNode head) {
        ListNode cur=head;
        String s="";
        if(head==null||head.next==null){
            return true;
        }

        while(cur!=null){
            s+=String.valueOf(cur.val);
            cur=cur.next;
        }

        StringBuffer sb=new StringBuffer(s);
        StringBuffer reverseSb=sb.reverse();
        if(s.equals(reverseSb.toString())){
            return true;
        }else{
            return false;
        }

    }
}
