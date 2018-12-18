package com.whh;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2018/12/18 15:31
 * @Description:
 * @Author admin
 */
public class TestMain {
    public static void main(String[] args) {

        List<Integer> list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.forEach(item-> System.out.println(item));

    }
}
