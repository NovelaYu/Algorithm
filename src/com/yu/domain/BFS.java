package com.yu.domain;

import java.util.*;

/****
 * 广度优先搜索，队列优先，先查找第一个再找下一个
 *
 *
 */
public class BFS {

    public LinkedList getBFS(HashMap<String,String[]> hashMap,String str) {
        HashSet<String> set = new HashSet<>();
        LinkedList<String> list = new LinkedList<>();
        //用队列pull拿出栈顶元素，用元素的值去找字典表里的第一层值
        list.add(str);
        //用set去重,表示遍历了哪些元素
        set.add(str);
        while (list.size()>0){
            //pop移出队列的第一个(栈的方法)，push添加元素到对头
            //pull 移出第一个元素(队列的方法)，如果队列为空返回null
            String str1 = list.poll();
            System.out.println(str1);
            String[] result =hashMap.get(str1);
            for (String data:result) {
                if (set.contains(data)) {
                    continue;
                } else {
                  list.add(data);
                  set.add(data);
                }
            }
        }


        return list;
    }

    /****
     * 深度优先搜索，队列变为栈，先进后出
     *
     * @param hashMap
     * @param str
     * @return
     */

    public Stack<String> getDFS(HashMap<String,String[]> hashMap,String str) {
        HashSet<String> set = new HashSet<>();
        Stack<String> stack = new Stack<String>();
        //用队列pull拿出栈顶元素，用元素的值去找字典表里的第一层值
        stack.add(str);
        //用set去重,表示遍历了哪些元素
        set.add(str);
        while (stack.size()>0){
            //pop移出队列的第一个(栈的方法)，push添加元素到对头
            //pull 移出第一个元素(队列的方法)，如果队列为空返回null
            String str1 = stack.pop();
            System.out.println(str1);
            String[] result =hashMap.get(str1);
            for (String data:result) {
                if (set.contains(data)) {
                    continue;
                } else {
                    stack.add(data);
                    set.add(data);
                }
            }
        }


        return stack;
    }


    public static void main(String[] args) {
        HashMap<String,String[]> hashMap = new HashMap<>();
        //因为图是无序的，所以，这样表示各个节点的一层节点
        String[] s1 = {"B","C"};
        String[] s2 = {"A","C","D"};
        String[] s3 = {"E","F","B","C"};
        String[] s4 = {"A","B","D","E"};
        String[] s5 = {"C","D"};
        String[] s6 = {"D"};
        hashMap.put("A",s1);
        hashMap.put("B",s2);
        hashMap.put("D",s3);
        hashMap.put("C",s4);
        hashMap.put("E",s5);
        hashMap.put("F",s6);


        BFS bfs = new BFS();
        LinkedList<String> list = (LinkedList<String>)bfs.getBFS(hashMap,"B");
        Stack<String> stack =  bfs.getDFS(hashMap,"B");

    }
}
