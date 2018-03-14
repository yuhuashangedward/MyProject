package com.alibaba.demo;

import java.util.ArrayList;


public class Test {

        public void testHeap(){
            for(;;){
                ArrayList list = new ArrayList (2000);
                System.err.println("堆");
            }
        }
        int num=1;
        public void testStack(){
            num++;
            this.testStack();
            System.err.println("栈");
        }

        public static void main(String[] args){
            Test  t  = new Test ();
            t.testHeap();
            t.testStack();
        }
 }

