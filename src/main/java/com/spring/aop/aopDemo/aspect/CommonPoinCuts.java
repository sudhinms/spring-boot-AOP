package com.spring.aop.aopDemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPoinCuts {

    @Pointcut("execution(* com.spring.aop.aopDemo.service.*.*(..))")
    public void servicePointCut(){}

    @Pointcut("bean(* dao2 *)")
    public void dao2PointCut(){}

    @Pointcut("within(com.spring.aop.aopDemo.service..*)")
    public void withinPointCut(){}

    @Pointcut("@annotation(com.spring.aop.aopDemo.aspect.TrackTime)")
    public void trackTimePointcut(){

    }
}
