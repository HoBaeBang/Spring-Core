package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component  //bean과 컴포넌트의 차이 : 빈은 클래스에 붙일수가 없다. 빈은 메서드에서 사용 할수 있다
public class TimerAop { //특정 클래스 메소드의 동작시간을 찍음

    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut() {
    }

    @Pointcut("@annotation(com.example.aop.annotation.Timer)")
    private void enableTimer() {
    }


    @Around("cut() && enableTimer()")
    private void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = proceedingJoinPoint.proceed();

        stopWatch.stop();

        System.out.print("total time : " + stopWatch.getTotalTimeSeconds());
    }

}
