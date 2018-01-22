package com.alibaba.demo;

import java.math.BigDecimal;

/**
 * 对字符和汉字的讨论
 */
public class DemoThird {
    public static void main(String[] args){

        String st="中国人名";
        String st1="I love china!";
        String st2="$%^%$**%&";
        String st3="      ";
        String st4="  shfgkdhg  ";
        System.err.println(st.length());
        System.err.println(st1.length());
        System.err.println(st2.length());
        System.err.println(st3.length());
        System.err.println(DemoThird.isNickname(st));
        System.err.println(DemoThird.isNickname(st1));
        System.err.println(DemoThird.isNickname(st2));
        System.err.println(DemoThird.isNickname(st3));
        System.err.println(DemoThird.isNickname(st4));

        double d1 = 1.0001;
        double d2 = 1.00001;
        BigDecimal b1 = BigDecimal.valueOf(1.0001);
        BigDecimal b2 = BigDecimal.valueOf(1.00001);

        System.err.println(d1+d2);
        System.err.println(b1.add(b2));
    }


    public static boolean isNickname(String str){
        if(str.isEmpty() || "".equals(str.trim()) || str.length()==0 || str.trim().length()>16){
            return false;
        }
        return true;
    }
}
