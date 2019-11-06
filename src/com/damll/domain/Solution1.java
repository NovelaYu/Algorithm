package com.damll.domain;

//类的可见性至少是包可见

public class Solution1 {

      static class ListNode {
          public int val;
          public ListNode next;
          public ListNode(int x){
              this.val =x;
          }
      }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }else if (l2 == null) {
            return l1;
            //用递归算法
        }else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }

    }

}
