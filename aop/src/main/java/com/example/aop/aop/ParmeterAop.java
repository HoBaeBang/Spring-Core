package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParmeterAop {

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut() {
    }

    @Before("cut()")        //위에 있는 저 하위의 메서드들이 실행이되기 전에 먼저 실행이되고
    public void before(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        Object[] args = joinPoint.getArgs();
        for (Object obj : args) {
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value : " + obj + "\n");
        }
    }

    @AfterReturning(value = "cut()", returning = "returnObj")        // 저위의 포인트 컷 반환값에 대한 내용을 볼수있음
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println("\nreturn obj");
        System.out.println(returnObj);
    }

}
