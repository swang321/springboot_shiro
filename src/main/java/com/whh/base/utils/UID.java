package com.whh.base.utils;

import java.util.UUID;

/**
 * @ProjectName: swang
 * @Author: swang
 * @Date: 2018/9/4 16:35
 * @Description:
 */
public class UID {
    public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        return uuidStr;
    }
}
