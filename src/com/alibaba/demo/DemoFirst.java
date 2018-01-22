package com.alibaba.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoFirst {

    // Java数组去重
    public static void main(String[] args){
       // System.out.print("Hello World!");

        String[] array ={"a","b","c","d","a","c"};
        List<String> result = new ArrayList<>();
        boolean flag;
        for(int i = 0;i<array.length;i++){
            flag = false;
            for (int j=0;j<result.size();j++){
                if(array[i].equals(result.get(j))){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                result.add(array[i]);
            }
        }

        String[] arrayResult = result.toArray(new String[result.size()]);
        System.err.print(Arrays.toString(arrayResult));
    }
}
