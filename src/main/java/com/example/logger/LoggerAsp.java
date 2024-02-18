package com.example.logger;
import java.util.logging.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LoggerAsp {
    private static final Logger logger = Logger.getLogger(LoggerAsp.class.getName());
    @After("execution(* com.example.controller..*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("Exiting method: {}" + joinPoint.getSignature().getName());
    }

}
