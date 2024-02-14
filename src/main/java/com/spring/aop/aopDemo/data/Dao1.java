package com.spring.aop.aopDemo.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {

    public String retrieveData(){
        return "business data (Dao1)";
    }
}
