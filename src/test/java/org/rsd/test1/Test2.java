package org.rsd.test1;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class Test2 {

    @Test
    public void test1() {
        Apple apple = new Apple();
        Pear pear = new Pear();
        FruitProxy1_1 proxy = new FruitProxy1_1(pear);
        Float result = proxy.sale(100f, 40f);
        System.out.println(result);
    }

    @Test
    public void test2() {
        Apple apple = new Apple();
        Pear pear = new Pear();
        FruitProxy1_2 proxy = FruitProxy1_2.getProxy(pear);
        Float result = proxy.sale(100f, 40f);
        System.out.println(result);
    }

    @Test
    public void test3() {
        Apple apple = new Apple();
        FruitProxy2 proxy = new FruitProxy2();
        IFruit fruit = proxy.getProxy(apple);
        Float result = fruit.sale(100f, 50f);
        System.out.println(result);
    }

    @Test
    public void test4() {
        Apple apple = new Apple();
        FruitProxy3 proxy = new FruitProxy3();
        IFruit fruit = proxy.getProxy(apple);
        fruit.sale(100f, 50f);
    }

    @Test
    public void test5() {
        DogProxy dogProxy = new DogProxy();
        Dog dog = dogProxy.getProxy(new Dog());
        dog.run();
    }
}
