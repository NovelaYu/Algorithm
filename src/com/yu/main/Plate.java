package com.yu.main;

public class Plate<T> {
    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    private T item;
    public Plate(T t) {
        item = t;
    }

    public static void main(String[] args) {
        /*编译会报错，如何把Plate的引用传递给Plate*/
      /*  Plate<Fruit> plate = new Plate(new Fruit());
        Fruit fr1 = new Fruit();
        plate.setItem(fr1);*/
      /*  Plate<? extends Fruit> plate = new Plate<Apple>(new Apple());
        plate.setItem(new Fruit());
        plate.setItem(new Apple());
        Fruit fruit = plate.getItem();
        Apple apple = plate.getItem();
        Object fruit2 = plate.getItem();*/


        /*Plate<? super Fruit> plate1 = new Plate<>(new Apple());
        plate1.setItem(new Fruit());
        plate1.setItem(new Apple());
        Fruit fruit = plate1.getItem();
        Object object = plate1.getItem();
        Apple apple = plate1.getItem();*/
    }

}
