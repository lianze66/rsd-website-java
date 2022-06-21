package org.rsd.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class OurAdvice {

    @Pointcut("execution(* org.rsd.service.impl.*.*(..))")
    private void pointcut() {

    }

    @Before("pointcut()")
    public void before() {
        System.out.println("&&&&&&&&&&&&&&&&& 前置通知 &&&&&&&&&&&&&&&&&&&&&");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("&&&&&&&&&&&&&&&&& 后置通知 &&&&&&&&&&&&&&&&&&&&&");
    }

    @Around("execution(* org.rsd.service.impl.*.*(..))")
    public Object round(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("&&&&&&&&&&&&&&&&& 环绕通知(start) &&&&&&&&&&&&&&&&&&&&&");
        Object proceed = joinPoint.proceed();
        System.out.println("&&&&&&&&&&&&&&&&& 环绕通知(end) &&&&&&&&&&&&&&&&&&&&&");
        return proceed;
    }
}
