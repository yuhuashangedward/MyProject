package com.alibaba.demo.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUtil {

    @SafeVarargs
    public static <T> List<T> buildList(T... objs){
        List<T> list = new ArrayList<T>();
        if(objs!=null){
            for(T obj:objs){
                list.add(obj);
            }
        }
        return list;
    }

    // 讲对象封装成Map
    public static Map<String,Object> buildMap(Object... objs){
        Map<String,Object> map = new HashMap<String,Object>();
        if(objs!=null){
            int size = objs.length/2;
            for(int i=0;i<size;i++){
                Object key = objs[i*2];
                Object value = objs[i*2+1];
                if(key!=null){
                    map.put(key.toString(), value);
                }
            }
        }
        return map;
    }

    /*public static void bean2map(Map<String,Object> m,Object obj){
        // Spring 架构
        // import org.springframework.beans.BeanWrapper;
        BeanWrapper beanWrapper = new BeanWrapperImpl(obj);
        PropertyDescriptor[] descriptor = beanWrapper.getPropertyDescriptors();
        for (int i = 0; i < descriptor.length; i++) {
            m.put(descriptor[i].getName(),beanWrapper.getPropertyValue(descriptor[i].getName()));
        }
    }*/

    public static <T> void map2bean(T obj,Map<String,Object> m){
        try {
            BeanUtils.populate(obj, m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Map<String,Object> map = MapUtil.buildMap("email","2222@2.com","nickname","abc");
        System.out.println(map);
    }

}
