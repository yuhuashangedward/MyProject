package com.alibaba.demo;

import com.alibaba.demo.utils.GoogleAuthUtils;

public class GoogleTest {

    public static void main(String[] args){
        Boolean authcode = GoogleAuthUtils.authcode("472019", "S46ZDB3NK3K5DXOD");
        System.err.println(authcode);
    }

}
