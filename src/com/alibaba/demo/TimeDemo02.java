package com.alibaba.demo;

import java.sql.Timestamp;
import java.util.Date;

public class TimeDemo02 {

    public static void main(String[] args){
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Date date = new Date();
        try {
            date = ts;
            System.out.println(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
