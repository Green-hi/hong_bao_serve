package com.greenhi.hongBao.unit;

import java.util.Random;

/**
 * 随机字符串生成类
 */
public class RandomUnit {

    /**
     * 生成登录权鉴
     * @return
     */
    public static String getLoginToken(){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<15;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
