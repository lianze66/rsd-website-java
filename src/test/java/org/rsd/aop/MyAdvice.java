package org.rsd.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {

    public void info1(JoinPoint joinpoint) {
        System.out.println("*************** 我是前置通知() ********************");
    }

    public void info2(JoinPoint joinpoint) {
        System.out.println("*************** 后置通知 ************************");
    }

    public Object info3(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("*************** 环绕通知(start) ************************");
        Object proceed = joinPoint.proceed();
        System.out.println("*************** 环绕通知(end) ************************");
        return proceed;
    }
}
