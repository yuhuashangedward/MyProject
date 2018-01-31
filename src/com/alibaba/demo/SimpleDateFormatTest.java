/*
package com.alibaba.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleDateFormatTest {

    static volatile AtomicInteger n = new AtomicInteger(-1);

    static ThreadLocal<DateFormat> sdf;

    static {
        sdf = new ThreadLocal<DateFormat>(){
            @Override
            protected  DateFormat initalValue(){
                return new SimpleDateFormat("yyyy-MM-dd");
            }
        };
    }*/
/**//*


    public static void main(String[] args){
        Set<String> dateSet = new ConcurrentHashSet<>();
        Set<Integer> numberSet = new ConcurrentHashSet<>();

        Date[] dates = new Date[1000];
        for (int i = 0; i<1000; i++){
            dates[i] = sdf.get().parse(i+1000+"-11-22");
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i <1000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    int number = n.incrementAndGet();
                    String date = sdf.get().format(dates[number]);
                    numberSet.add(number);
                    dateSet.add(date);
                    System.out.println(number +""+ date);
                }
            });
        }
        executorService.shutdown();
        Thread.sleep(5000);
        System.out.println(dateSet.size());
        System.out.println(numberSet.size());
    }
}
*/
