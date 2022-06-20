package org.rsd.test1;

public class Apple implements IFruit {
    @Override
    public void sale() {
        System.out.println("我是苹果，我被出售了。");
    }

    @Override
    public Float sale(Float money, Float price) {
        return money = price;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
