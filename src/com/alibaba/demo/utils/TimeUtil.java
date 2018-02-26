package com.alibaba.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    public static void main(String[] args){

        //long time = 1519389126076L;
        //long time = 1519443311620L;
        long time = 0L;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");

        Date date = new Date();
        date.setTime(time);
        System.err.println(sdf.format(date));

    }
}
