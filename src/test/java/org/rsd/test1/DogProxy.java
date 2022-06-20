package org.rsd.test1;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DogProxy implements MethodInterceptor {

    private Dog dog;

    public Dog getProxy(Dog dog) {
        this.dog = dog;

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dog.class);
        enhancer.setCallback(this);
        return (Dog)enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = method.invoke(dog, objects);
        return result;
    }
}
