package com.alibaba.demo;

import java.math.BigDecimal;

public class ArthTest {

    public static void main(String[] args){
        System.err.println("hello");

        boolean b = 8>5 ? true:false;

       /* System.out.println(new BigDecimal("20.003450").stripTrailingZeros());
        System.out.println(new BigDecimal("20.003450").stripTrailingZeros().toString());
        System.out.println(new BigDecimal("20.003450").stripTrailingZeros().toPlainString());
        System.out.println(BigDecimal.ZERO);
        System.err.println(b);*/

        System.err.println("++++++++++++++++++++++++++++++++++++====================================++++++++++++++++++++++++++");
        System.out.println(new BigDecimal("20.003450").setScale(3, BigDecimal.ROUND_HALF_DOWN));
        System.out.println(new BigDecimal("20.003450").setScale(4, BigDecimal.ROUND_HALF_UP));
        System.out.println(new BigDecimal("20.003450").setScale(4, BigDecimal.ROUND_HALF_EVEN));
        System.out.println(new BigDecimal("20.003450").setScale(3,BigDecimal.ROUND_CEILING));
    }

}
