package com.alibaba.demo.utils;

import java.util.UUID;

//用于保存Request的ThreadLocal
public class IdempotentTool {

    private static ThreadLocal<String>  threadlocal1 = new ThreadLocal<>();
    private static ThreadLocal<String>  threadlocal2 = new ThreadLocal<>();

    public static void setRequestId(String value){
        threadlocal1.set(value);
    }

    public static String getRequestId(){
        return threadlocal1.get();
    }

    public static void clearRequestId1(){
        threadlocal1.remove();
    }

    public static String createRequestId(int reqTepmlateId){
        String uid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        String value = reqTepmlateId+"_"+uid;
        threadlocal2.set(value);
        return uid;
    }

    public static String getRequestId(int reqTepmlateId){
        String value = threadlocal2.get();
        if(value==null)return null;
        String[] words = value.split("_");
        if(words.length!=2){
            threadlocal2.remove();
            return null;
        }
        if(!words[0].equals(reqTepmlateId+"")){
            threadlocal2.remove();
            return null;
        }
        return words[1];
    }

    public static void clearRequestId2(){
        threadlocal2.remove();
    }
}
