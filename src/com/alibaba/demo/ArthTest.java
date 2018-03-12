package com.alibaba.demo;

import java.math.BigDecimal;

public class ArthTest {

    public static void main(String[] args){
        System.err.println("hello");

        boolean b = 8>5 ? true:false;

        System.out.println(new BigDecimal("20.003450").stripTrailingZeros());
        System.out.println(new BigDecimal("20.003450").stripTrailingZeros().toString());
        System.out.println(new BigDecimal("20.003450").stripTrailingZeros().toPlainString());
        System.err.println(b);
    }

}
