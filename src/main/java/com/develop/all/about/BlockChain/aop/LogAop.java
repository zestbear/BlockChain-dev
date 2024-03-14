package com.develop.all.about.BlockChain.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // Aop
@Component // Bean 주입
@Slf4j // Logback
public class LogAop {

    /*
        LogExecutionTime 어노테이션이 붙은 METHOD들에 대해 실행 시간 측정
     */
    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info(joinPoint.getTarget().getClass().toString() + "." + proceed.toString() + ": " + (double) (endTime - startTime) / 1000);
        return proceed;
    }

}
