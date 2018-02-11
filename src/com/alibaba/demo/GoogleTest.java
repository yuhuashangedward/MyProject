package com.alibaba.demo;

import com.alibaba.demo.utils.GoogleAuthUtils;

public class GoogleTest {

    public static void main(String[] args){
        Boolean authcode = GoogleAuthUtils.authcode("641717", "FHMPUXLOAN2JRG6J");
        System.err.println(authcode);
    }

}
