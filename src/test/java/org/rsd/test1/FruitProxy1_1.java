package org.rsd.test1;

public class FruitProxy1_1 implements IFruit {

    private IFruit fruit;

    public FruitProxy1_1(IFruit fruit) {
        this.fruit = fruit;
    }

    @Override
    public void sale() {
        System.out.println("---------------我要开启事务--------------");
        fruit.sale();
        System.out.println("---------------我要关闭事务--------------");
    }

    @Override
    public Float sale(Float money, Float price) {
        return money - price * 0.8f;
    }
}
