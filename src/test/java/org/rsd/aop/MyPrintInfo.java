package org.rsd.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class MyPrintInfo implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("------------我是后置通知-------------");
    }
}
