package org.rsd.test1;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLib动态代理
 */
public class FruitProxy3 implements MethodInterceptor {

    private IFruit fruit; // 被代理对象

    /**
     * 获得代理对象
     * @param fruit 被代理对象
     * @return 代理对象
     */
    public IFruit getProxy(IFruit fruit) {
        this.fruit = fruit;

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(IFruit.class);
        enhancer.setCallback(this);
        return (IFruit)enhancer.create();
    }

    /**
     * 被代理对象执行的方法
     * @param o 代理对象
     * @param method 代理类的方法
     * @param objects 代理类的方法参数
     * @param methodProxy 代理对象的方法
     * @return 代理对象的结果
     * @throws Throwable 异常
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("---------------------哈哈-------------------------");
        Object result = method.invoke(fruit, objects);
        System.out.println(result);
        System.out.println("---------------------结束了-------------------------");
        return result;
    }
}
