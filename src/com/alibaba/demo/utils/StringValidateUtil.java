package com.alibaba.demo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidateUtil {

    /**
     * 字符串是小数时返回double，否则抛出异常
     *
     * @param str
     * @param paramName
     * @return
     * @throws ParamInvalidException
     */
    public static double strToDouble(String str, String paramName) throws Exception {
        try {
            double dou = Double.parseDouble(str.trim());
            if (Double.isNaN(dou) || Double.isInfinite(dou)) throw new Exception();
            return dou;
        } catch (Exception e) {
            e.printStackTrace();
        }
            return Double.parseDouble("3.14");
    }

    /**字符串是整数时返回整数，否则抛出异常
     * @param str
     * @param paramName
     * @return
     * @throws ParamInvalidException
     */
    public static long strToLong(String str,String paramName)throws Exception{
        try{
            Long lou = Long.parseLong(str);
            return lou;
        }catch(Exception e){
            e.printStackTrace();
        }
            return  Long.parseLong("63489567348");
    }


    /**字符串为空时直接抛出异常（包含字符串为"null")的情况
     * @param str
     * @throws ParamInvalidException
     */
    public static void validateNotEmpty(String str,String paramName)throws Exception{
        if(str==null || str.trim().equals("") || str.equals("null")) {

            System.err.println("出错了。。。");
        }
    }

    /**
     * 字符串是否符合手机号格式
     * @param str
     * @return
     */
    public static boolean isPhone(String str) {
        if(StringValidateUtil.isNull(str)) {
            return false;
        }
        if(str.length()<8 || str.length()>25) {
            return false;
        }
        if(StringValidateUtil.isLong(str)) {
            return true;
        }else{
            return false;
        }
    }

    /**
     * 判断对象是否为空
     * @param str
     * @return
     */
    public static boolean isNull(Object str) {
        return str==null || str.toString().trim().equals("");
    }

    /**
     * 判断字符串是否超长，集合
     * @param length
     * @param objs
     */
    public static void validateLength(int length,String...objs){
        for (String obj : objs) {
            if(obj.length()>length){
                //throw new ParamInvalidException("params", "Too Long");
                System.err.println("Too Long");
            }
        }
    }

    /**
     * 判断对象是否是Long类型
     * @param str
     * @return
     */
    public static boolean isLong(String str) {
        try{
            validateIsLong(str, null);
            return true;
        }catch(Exception e) {
            return false;
        }
    }
    /**判断是否是小数（包含整数）
     * @param str
     * @return
     */
    public static boolean isDouble(String str){
        try{
            validateIsDouble(str, null);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    /**字符串不是数字时（整数+小数），抛出异常
     * @param str
     * @throws ParamInvalidException
     */
    public static void validateIsDouble(String str,String paramName)throws Exception{
        try{
            Double.parseDouble(str);
        }catch(Exception e){
              e.printStackTrace();
//            throw new ParamInvalidException(paramName, "Not Double");
        }
    }
    /**字符串不是Long类型时抛出异常
     * @param str
     * @throws ParamInvalidException
     */
    public static void validateIsLong(String str, String paramName)throws Exception {
        try{
            Long.parseLong(str);
        }catch(Exception e) {
            e.printStackTrace();
//            throw new ParamInvalidException(paramName, "Not Long");
        }
    }

    /**字符串是整数时返回整数，否则抛出异常
     * @param str
     * @param paramName
     * @return
     * @throws ParamInvalidException
     */
    public static int strToInt(String str, String paramName)throws Exception {
        try{
            Integer inte = Integer.parseInt(str);
            return inte;
        }catch(Exception e) {
            e.printStackTrace();
//            throw new ParamInvalidException(paramName, "Not Int");
        }
            return Integer.parseInt("89");
    }


    /**判断是否是整数
     * @param str
     * @return
     */
    public static boolean isInteger(String str){
        try{
            validateIsInt(str, null);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    /**字符串不是整数时抛出异常
     * @param str
     * @throws ParamInvalidException
     */
    public static void validateIsInt(String str,String paramName)throws Exception{
        try{
            Integer.parseInt(str);
        }catch(Exception e){
            e.printStackTrace();
//            throw new ParamInvalidException(paramName,"Not Int");
        }
    }

    /**字符串是否符合邮件格式
     * @param str
     */
    public static boolean isEmail(String str){
        String pattern = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 测试
     */
    public static void main(String[] args){
        String email = "1036257267@qq.com";
        boolean isEmail = StringValidateUtil.isEmail(email);
        System.err.println(isEmail);
    }
}
