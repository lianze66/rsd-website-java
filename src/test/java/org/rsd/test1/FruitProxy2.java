package org.rsd.test1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 */
public class FruitProxy2 implements InvocationHandler {

    private IFruit fruit; // 被代理对象

    // 通过方法获得代理对象（proxy）
    public IFruit getProxy(IFruit fruit) {
        this.fruit = fruit;
        return (IFruit)Proxy.newProxyInstance(fruit.getClass().getClassLoader(), fruit.getClass().getInterfaces(), this);
    }

    /**
     * 接口自动执行的方法，代理对象（proxy）在调用某一方法时，自动调用被代理对象(fruit)的相同方法。
     * @param proxy 代理对象
     * @param method 代理类的方法
     * @param args 代理类方法的参数集合
     * @return 代理类的结果
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("------------------我来到水果店了------------------");
        Object result = method.invoke(fruit, args); // 自动调用被代理对象(fruit)的相同方法
        System.out.println("------------------我买完水果走了------------------");
        return result;
    }
}
