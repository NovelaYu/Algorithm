package com.yu.main;


/***
 * @Author yu.xiang
 * 将链表 1->2->3->4->5 顺序变为5->4->3->2->1
 *
 * **/
public class CovertNode {

    /**
    * @Author: yu.xiang
    * @Description:
    * @Date: 12:35 2021/5/13
     * 内部类，有个链表
    **/

    //class ListNode 是一个非静态的内部类，只能被该类的非静态方法访问
    public static class ListNode {

        private int i;
        private ListNode next;

        private ListNode(int i, ListNode next) {
            this.i = i;
            this.next = next;
        }
    }


    /***
     * 1、迭代法，将本节点保存下来，
     * 2、将本节点下一个节点保存下来，
     * 2、本节点下一个指针指向上一个节点(第一个上一个节点为null)
     * 3、本节点下一个节点的下一个指针指向上一个节点
     * 4、将下一个节点变为当前节点
     * **/

    public static ListNode iteatore(ListNode node) {
        ListNode curr = node;
        ListNode pre = null,next;
        while (curr != null) {
            // 1、将下一个节点的下一个指针保留下来
            next = curr.next;
            // 2、将当前节点的指针指向上一个节点，第一个节点为空
            curr.next = pre;
            // 3、将下一个节点变成当前节点，以便下一次循环
            pre = curr;
            // 4、将当前节点变成上一个节点，以便下一次指向
            curr = next;

        }

        return node;
    }

    /**
    * 1、用递归方法来循环赋值
    **/

    public static ListNode recursion(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        recursion(node.next);
        node.next.next = node;
        return node;
    }



    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5,null);
        ListNode listNode4 = new ListNode(4,listNode5);
        ListNode listNode3 = new ListNode(3,listNode4);
        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1,listNode2);
        CovertNode.recursion(listNode1);
    }


}
