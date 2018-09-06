package com.imooc.utils;

import java.util.UUID;

/**
 * @Auther: Leo
 * @Date: 2018/9/6 18:52
 * @Description:
 */
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
