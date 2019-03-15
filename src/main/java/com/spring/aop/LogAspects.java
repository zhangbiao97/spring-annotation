package com.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 告诉Spring这是一个切面类
 */
@Aspect
public class LogAspects {

    @Pointcut("execution(public * com.spring.aop.MathCalculate.*(..))")
    public void pointcut(){}


    @Before("pointcut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(""+joinPoint.getSignature().getName()+"开始运行，参数列表：{"+ Arrays.asList(args)+"}");
    }

    @After("pointcut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(""+joinPoint.getSignature().getName()+"运行结束");
    }

    @AfterReturning(value = "pointcut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(""+joinPoint.getSignature().getName()+"运行结果：{"+result+"}");
    }

    @AfterThrowing(value = "pointcut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println(""+joinPoint.getSignature().getName()+"发生异常，异常信息：{"+exception+"}");
    }

}
