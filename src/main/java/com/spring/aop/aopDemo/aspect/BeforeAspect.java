package com.spring.aop.aopDemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class BeforeAspect {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    // executes before the target methods
    @Before("com.spring.aop.aopDemo.aspect.CommonPoinCuts.servicePointCut()")
    public void before(JoinPoint joinPoint){
        logger.info("Intercepted method calls..........{} ",joinPoint);
    }

    // executes after the successful completion of target methods
    @AfterReturning(value = "execution(String com.spring.aop.aopDemo.service.*.*(..))",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        logger.info("AfterReturning {}  return value is : {}",joinPoint.getSignature(),result.toString());
    }

    // executes if the method throws an exception
    @AfterThrowing(value = "execution(String com.spring.aop.aopDemo.service.*.*(..))",throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint,Exception exception){
        logger.info("AfterThrowing {}  exception is : {}",joinPoint.getSignature(),exception.getMessage());
    }

    // Executes after target methods are executed whether it execute successfully or not
    @After(value = "execution(String com.spring.aop.aopDemo.service.*.*(..))")
    public void after(JoinPoint joinPoint){
        logger.info("After {}",joinPoint.getSignature());
    }

    // Execute before and after of target methods
//    @Around("com.spring.aop.aopDemo.aspect.CommonPoinCuts.trackTimePointcut()")
//    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
//        long startTime=System.currentTimeMillis();
//        joinPoint.proceed(); // used to execute target methods
//        long timeTaken=System.currentTimeMillis()-startTime;
//        logger.info("time taken for : "+joinPoint.getSignature()+" is : "+timeTaken);
//    }

    @Before("com.spring.aop.aopDemo.aspect.CommonPoinCuts.dao2PointCut()")
    public void beanPointCutCall(){
        logger.info("pointCut with bean name...");
    }

    @Before("com.spring.aop.aopDemo.aspect.CommonPoinCuts.withinPointCut()")
    public void within(){
        logger.info("using within....");
    }

    @Around(value = "@annotation(com.spring.aop.aopDemo.aspect.TrackTime)")
    public void aroundAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime=System.currentTimeMillis();
        joinPoint.proceed(); // used to execute target methods
        long timeTaken=System.currentTimeMillis()-startTime;
        logger.info("time taken for : "+joinPoint.getSignature()+" is : "+timeTaken);
    }
}
