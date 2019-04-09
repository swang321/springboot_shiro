package com.whh.component;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Date: 2019/1/25 11:34
 * @Description:
 * @Author admin
 */
@Component
public class TaskInit {


    @PostConstruct
    public void output(){
        System.out.println("输出-------------------------------------------------------------------------");
    }


}
