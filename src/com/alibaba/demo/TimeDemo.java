package com.alibaba.demo;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeDemo {

    public static void main(String[] args){
       /* Calendar c = Calendar.getInstance();

        c.add(Calendar.DAY_OF_MONTH, 1);

        System.out.println(c.getTime());*/
       getTomorrow();

    }

    public static Date getTomorrow(){

        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        Date today = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH, 1);// 今天+1天

        Date tomorrow = c.getTime();
        System.out.println(sdf.format(tomorrow));
        return tomorrow;
    }


}
