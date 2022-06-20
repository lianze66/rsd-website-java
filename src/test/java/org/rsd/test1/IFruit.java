package org.rsd.test1;

public interface IFruit {

    void sale();

    /**
     * 找零的方法
     * @param money 顾客给的钱
     * @param price 商品的价格
     * @return 找零
     */
    Float sale(Float money, Float price);

}
