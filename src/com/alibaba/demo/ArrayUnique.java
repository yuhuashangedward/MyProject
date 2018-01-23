package com.alibaba.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayUnique {

    public static void main(String[] args){
        Object[] arr = {1,2,3,4,5,6,8,9,0,2,1,4,6,67,5,4,3,1,23,34,5};
        Object[] newArray1 = arrayTest1(arr);
        System.err.println(Arrays.toString(newArray1));
        Object[] newArray = arrayTest2(arr);
        System.err.println(Arrays.toString(newArray));
    }


    // 传入一个Object数组，然后返回去重后的数组
    public static Object[] arrayTest1(Object[] arr){
        // 用来记录去重之后数组长度和给临时数组作为下表索引
        int t = 0;
        Object[] tempArr = new Object[arr.length];
        for(int i = 0;i < arr.length;i++){
            //声明一个标记，并每次去重
            boolean isTrue = true;
            // 如果有重复元素，改变标记状态并结束当次内层循环
            for (int j=i+1;j<arr.length;j++){
                if(arr[i] == arr[j]){
                    isTrue = false;
                    break;
                }
            }
            //判断标记是否被改变，如果没被改变就是没有重复元素
            if(isTrue){
                tempArr[t] = arr[i];
                // 到这里证明当前元素没有重复，那么记录自增
                t++;
            }
        }
        //声明需要返回的数组，这个才是去重后的数组
        Object[] newArr = new Object[t];
        // 用arraycopy方法将刚才去重的数组拷贝到新数组并返回
        System.arraycopy(tempArr,0,newArr,0,t);
        return newArr;
    }


    // 方法二：利用hashset去重
    public static Object[] arrayTest2(Object[] arr){
        // 实例化一个set集合
        Set<Object> set = new HashSet<>();
        // 遍历数组并存入集合，如果元素已存在则不会重复存入
        for(int i = 0; i< arr.length;i++){
            set.add(arr[i]);
        }
        // 返回set集合的数组形式
        return set.toArray();
    }
 }
