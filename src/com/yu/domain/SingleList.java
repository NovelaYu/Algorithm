package com.yu.domain;
/**
 * 这就是一个节点，节点连接节点
 * 1、如何手写一个链表
 * a、链表的数据结构：链表是由一个一个节点构成，每个节点包含数据域和指针域，
 *  数据域存储的事节点的数据，指针域存储的是下一个节点的地址。
 *  a.1、如何用代码来表示呢？
 *  答：用函数表示，如果将一个函数抽象成一个结点，那么给函数添加两个属性，一个属性存放数据域名，一个属性存放指针域
 * b、链表的操作方式：插入头部，删除头部，插入尾部，删除尾部，中间插入，中间删除
 *c、边界条件：如输入为空，不能执行后面程序；特殊边界，随意插入地方
 * d、测试用例
 * **/
public class SingleList<T> {

    // 定义头结点
    private Node head;
    //定义一个泛型数据,通过构造函数制造无数个节点
    // 节点是链表的一个成员内部类，内部类默认拥有外部类所有成员属性和成员方法，包括私有变量和静态成员
    // 内部类和外部类同名时，默认访问内部类，如果要访问外部类，请带上外部类的类名
    public class Node<T> {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
            next =null;
        }
    }

    //初始化头结点，也可以不初始化，直接在添加元素的时候赋值
    public SingleList() {
         this.head = new Node(0);
    }


    //查询根据位置查询节点

    public Node getNodeByIndex(int index,SingleList singleList) {
        int length = singleList.size();
        if (index <0 || index > length-1) {
            throw new RuntimeException("IndexOutOfBoundsException");
        }
        int position = 0;
        if (index == 0) {
            return head;
        }
        // 从头结点开始遍历
        Node cur = head;
        while (position < index) {
            cur = cur.next;
            position++;
        }
     return cur;
    }


    //删除头结点
    public void deletHeadNode() {
        head.next = head;
    }


    //删除尾结点
    public void deletLastNode() {
        int position = 0;
        // 当前节点
        Node cur = null;
        while (position <size()) {
            cur = head.next;
            position++;
        }
        cur.next = null;

    }

    //插入节点到指定位置
    public void addNodeAtIndex(T value, int index) {
        if (index <0 || index > this.size()-1) {
            throw new RuntimeException("IndexOutOfBoundsException");
        }

        // ==0就是插入到头结点之前
        if (index ==0) {
            addHeadNode(value);
        // 插入到尾部
        }else if (index == size()) {
            addLastNode(value);
        }else {
            Node newNode = new Node(value);
            int position = 0;
            /**
             * 标记当前节点,从头开始遍历
             * 临时节点很重要，在遍历的时候赋予临时节点头结点的值，后面可以依次遍历
             * **/
            Node cur = head;
            while (position < index) {
                cur = cur.next;
                position++;
            }
            //中间插入
            newNode.next = cur.next;
            cur.next = newNode;
        }


    }


    //插入尾结点
    public void addLastNode(T value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }else if (head.next == null) {
            head.next = newNode;
            return;
        } else {
            //找到最后一个节点
            Node last = head;
            int cur = 1;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }

    }


    //插入头结点（插在头结点之前）
    public void addHeadNode(T value) {
        Node newNode = new Node(value);
        //如果头结点不存在，则当前节点为头结点
        if (head == null) {
            head = newNode;
            return;
        }

        // 新节点指向头结点
        newNode.next = head;

    }

    //求链表的长度
    public int size() {
        int size = 1;
        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            return size;
        }
        /***
         * 一定要用个临时变量，否则用 head = head.next时会把链表全都覆盖掉，
         * 导致最后链表就只有最后一个节点了。
         * 用个临时变量，不然把head全覆盖了
         * **/
        Node cur = head;
        while (cur.next !=null) {
            cur = cur.next;
            size++;
        }
        return size;
    }

    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        singleList.addLastNode("第一个节点");
        singleList.addLastNode("第二个节点");
        singleList.addLastNode("第三个节点");
        singleList.addLastNode("第四个节点");
        singleList.addNodeAtIndex("第一个位置后面插入一个节点",3);
        int size = singleList.size();
        for (int i =0;i<size;i++) {
            System.out.println(singleList.getNodeByIndex(i,singleList).value +"\n");
        }
    }

}
