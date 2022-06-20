package org.rsd.test1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test3 {

    public static void main(String[] args) {
        Apple apple1 = new Apple();
        apple1.setName("红富士");

        Apple apple2 = new Apple();
        apple2.setName("果光");

        try {
            Class<? extends Apple> clazz = apple1.getClass();
            Method method = clazz.getMethod("getName", null);
            Object invoke = method.invoke(apple2);
            System.out.println(invoke);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
