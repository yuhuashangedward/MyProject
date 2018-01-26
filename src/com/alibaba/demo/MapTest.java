package com.alibaba.demo;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args){

        Map<String, Object> register = MapTest.buildMap();
        System.err.println(register.size());
    }


    // 将对象转换为Map
    public static <T> Map<String,T> buildMap(Object ... objs) {
        Map<String,T> map = new LinkedHashMap<String,T>();
        if(objs!=null){
            int size = objs.length/2;
            for(int i=0;i<size;i++){
                Object key = objs[i*2];
                T value = (T) objs[i*2+1];
                if(key!=null){
                    map.put(key.toString(), value);
                }
            }
        }
        return map;
    }
}
