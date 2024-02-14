package com.spring.aop.aopDemo.service;

import com.spring.aop.aopDemo.aspect.TrackTime;
import com.spring.aop.aopDemo.data.Dao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService2 {
    @Autowired
    private Dao2 dao2;

    @TrackTime
    public String businessMethod2(){
        return dao2.retrieveData();
    }
}
