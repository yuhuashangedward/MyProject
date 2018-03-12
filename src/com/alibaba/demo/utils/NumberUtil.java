package com.alibaba.demo.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class NumberUtil {
    //向远离0方向舍入
    public static final int UP = 0;
    //向靠近0方向舍入
    public static final int DOWN = 1;
    //四舍五入
    public static final int HALF = 4;
    //向正无穷方向舍入
    public static final int CELLING = 2;
    //向负无穷方向舍入
    public static final int FLOOR = 3;
    //五舍六入
    public static final int HALF_DOWN = 5;
    //四舍六入， 五根据前一位奇偶判断
    public static final int HALF_EVEN = 6;


    public static String getString4CNY(BigDecimal bd){
        if(bd==null){
            return "0.0";
        }else{
            return bd.setScale(1, HALF).toString();
        }
    }

    public static String getString4USD(BigDecimal bd){
        if(bd==null){
            return "0.00";
        }else{
            return bd.setScale(2, HALF).toString();
        }
    }

    public static String getString4DC(BigDecimal bd){
        if(bd==null){
            return "0.0000";
        }else{
            return bd.setScale(4, FLOOR).toString();
        }
    }

    public static String getString4DC10(BigDecimal bd){
        if(bd==null){
            return "0.0000000000";
        }else{
            return bd.setScale(10, FLOOR).toString();
        }
    }

    public static String getString4CNY(double bd){
        return NumberUtil.getString4CNY(new BigDecimal(bd+""), HALF);
    }

    public static String getString4USD(double bd){
        return  NumberUtil.getString4USD(new BigDecimal(bd+""), HALF);
    }

    public static String getString4DC(double bd){
        return  NumberUtil.getString4DC(new BigDecimal(bd+""), FLOOR);
    }

    public static String getString4DC10(double bd){
        return  NumberUtil.getString4DC10(new BigDecimal(bd+""), HALF);
    }

    public static String getString4CNY(BigDecimal bd,int mode){
        return bd.setScale(1, mode).toString();
    }

    public static String getString4USD(BigDecimal bd,int mode){
        return bd.setScale(2, mode).toString();
    }

    public static String getString4DC(BigDecimal bd,int mode){
        return bd.setScale(4, mode).toString();
    }

    public static String getString4DC10(BigDecimal bd,int mode){
        return bd.setScale(10, mode).toString();
    }

    public static String getString4CNY(double bd,int mode){
        return NumberUtil.getString4CNY(new BigDecimal(bd+""), mode);
    }

    public static String getString4USD(double bd,int mode){
        return  NumberUtil.getString4USD(new BigDecimal(bd+""), mode);
    }

    public static String getString4DC(double bd,int mode){
        return  NumberUtil.getString4DC(new BigDecimal(bd+""), mode);
    }

    public static String getString4DC10(double bd,int mode){
        return  NumberUtil.getString4DC10(new BigDecimal(bd+""), mode);
    }

    /**保留两位小数百分比
     * @param bd
     * @return
     */
    public static String getString4Percentage(double bd){
        NumberFormat fmt = NumberFormat.getPercentInstance();
        fmt.setMaximumFractionDigits(2);
        return fmt.format(bd);
    }

    public static void main(String [] args){

        String dd = NumberUtil.getString4DC(3.1426843);
        String dc = NumberUtil.getString4DC(3.14260087);

        System.err.println(dd);
        System.err.println(dc);
    }
}
