package com.alibaba.demo;

public class DemoFourth {

    public static void main(String[] args){
        System.err.println("Hell");
        String regex = ".{8,32}";
        String st = "783%$&$^$jgfdh";
        String st1 = "1234567";
        String st2 = "12345671234567891245678948641351311";
        String st3 ="         ";
        System.err.println(st.matches(regex));
        System.err.println(st1.matches(regex));
        System.err.println(st2.matches(regex));
        System.err.println(st3.matches(regex));


        int[] y= new int[]{1,2,3,4,5};
        System.err.println(y);

    }
}
