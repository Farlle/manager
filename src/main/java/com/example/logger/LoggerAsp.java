package com.example.logger;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggerAsp {
    private static final Logger logger = Logger.getLogger(LoggerAsp.class.getName());

    @After("execution(* com.example.controller..*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("Method executed  " + joinPoint.getSignature().getName());
    }

}
