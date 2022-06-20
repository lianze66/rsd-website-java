package org.rsd.test1;

public class Pear implements IFruit {
    @Override
    public void sale() {
        System.out.println("我是梨，我被出售了。");
    }

    @Override
    public Float sale(Float money, Float price) {
        return money - price;
    }
}
