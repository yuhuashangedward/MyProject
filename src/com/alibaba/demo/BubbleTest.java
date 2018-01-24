package com.alibaba.demo;

import java.util.Arrays;

public class BubbleTest {

    public static void main(String[] args){

        int[] numbers = {12,4,52,5,6,54,2,4};
        System.err.println(Arrays.toString(numbers));
        bubbleSort(numbers);
    }

    /**
     * 比较相邻元素。如果第一个比第二个大就交换他们
     */
    public static void bubbleSort(int[] numbers){
        int temp; //记录临时中间值
        int size = numbers.length; //数组大小
        for(int i= 0; i<size -1; i++){
            for(int j = i+1;j<size; j++){ //交换两数的位置
                if(numbers[i]<numbers[j]){
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        System.err.println(Arrays.toString(numbers));
    }
}
