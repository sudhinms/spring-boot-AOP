package com.spring.aop.aopDemo.data;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Repository;

@Repository
public class Dao2 {
    public String retrieveData(){
        return "business data (Dao2)";
    }
}
