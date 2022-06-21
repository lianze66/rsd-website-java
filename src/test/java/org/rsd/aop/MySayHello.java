package org.rsd.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MySayHello implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("-------------我是环绕通知(start)----------------");
        Object proceed = invocation.proceed();
        System.out.println("-------------我是环绕通知(end)----------------");
        return proceed;
    }
}
