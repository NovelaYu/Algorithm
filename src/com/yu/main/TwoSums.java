package com.yu.main;

import com.yu.domain.LinkNode;
import com.yu.domain.SingleList;

import java.util.Stack;

/**
* @Author: yu.xiang
* @Description:
* @Date: 10:22 2020/7/21
 *
 * 两数之和，这道题的精髓就是要固定住头节点
 * 链表要固定住头节点，可以产生各种临时链表从头节点开始赋值或者操作
**/

public class TwoSums {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     int tmp = 0;
     if (l1 == null) {
         return l2;
     }
     if (l2 == null) {
         return l1;
     }

     /**一个获取链表节点的动态变量**/
     ListNode dummyHead = new ListNode(0);


     /**这一步很重要，curr的变化会导致dummyhead的变化,因为他们指向同一头节点
      * curr这是一个临时节点，临时节点变化会导致链表节点变化，因为他和头节点建立了联系
      * 1、curr和head 都指向同一个头节点
      * 2、curr.next 表示头节点增加了一个节点
      * 3、curr = curr.next 表示curr指向了头节点的下一个节点
      * 4、通过curr的移动来增加链表的长度
      *
      * **/
     ListNode curr = dummyHead;
     while (l1 != null || l2 != null) {
         int var1 = l1!=null?l1.val:0;
         int var2 = l2!=null?l2.val:0;
         int var3;
         if (var1+var2+tmp > 10) {
             tmp = 1;
             var3 = (var1 + var2)%10;
         }else {
             var3 = var1 + var2;
             tmp = 0;
         }
         ListNode l3 =new ListNode(var3);
         /**关键在这一步，赋值给后一个，后一个给前一个**/
         curr.next = l3;
         /**上一个节点赋给了当前节点，自然当前节点就是最新的节点了**/
         curr = curr.next;
         /**需要定义一个临时变量，不然head.next的值会把head**/
         //dummyHead = dummyHead.next;

         l1 = l1.next;
         l2 = l2.next;
     }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        TwoSums twoSums =new TwoSums();
        ListNode l1 = twoSums.new ListNode(0);

        /*l1.next = twoSums.new ListNode(2);
        l1.next.next = twoSums.new ListNode(3);*/

        ListNode curr1 = l1;
        curr1.next = twoSums.new ListNode(2);
        curr1 = curr1.next;


        ListNode l2 = twoSums.new ListNode(3);

        l2.next = twoSums.new ListNode(4);
        l2.next.next = twoSums.new ListNode(6);

        ListNode list = twoSums.addTwoNumbers(l1,l2);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}
