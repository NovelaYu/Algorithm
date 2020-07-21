package com.yu.domain;

/**
* @Author: yu.xiang
* @Description:
* @Date: 13:01 2020/7/10
**/

public class LinkNode<T> {
    private LinkNode linkNode;
    //泛型和Object 都只能调用Object类型的参数和返回值
    // 泛型可以有更灵活的类型转换
    private T t;

    public LinkNode(T t) {
        this.t = t;
    }
}
