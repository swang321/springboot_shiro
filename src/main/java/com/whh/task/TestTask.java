package com.whh.task;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Date: 2018/12/4 17:34
 */
@Component
public class TestTask {


    @PostConstruct
    public void tt(){
        System.out.println("------------------------------------------");
    }

}
