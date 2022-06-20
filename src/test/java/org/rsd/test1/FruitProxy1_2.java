package org.rsd.test1;

public class FruitProxy1_2 implements IFruit {

    private static IFruit fruit;

    public static FruitProxy1_2 getProxy(IFruit iFruit) {
        fruit = iFruit;
        return new FruitProxy1_2();
    }

    @Override
    public void sale() {
        System.out.println("---------------我要开启事务--------------");
        fruit.sale();
        System.out.println("---------------我要关闭事务--------------");
    }

    @Override
    public Float sale(Float money, Float price) {
        return fruit.sale(money, price) + 5;
    }
}
