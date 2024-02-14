package com.spring.aop.aopDemo.service;

import com.spring.aop.aopDemo.aspect.TrackTime;
import com.spring.aop.aopDemo.data.Dao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BusinessService1 {
    @Autowired
    private Dao1 dao1;

    @TrackTime
    public String businessMethod1(){
        List<Integer> list=new ArrayList<>();
        if(list.isEmpty()){
            throw new RuntimeException("list is empty");
        }
        return dao1.retrieveData();
    }
}
