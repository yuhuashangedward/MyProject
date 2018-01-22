package com.alibaba.demo;

/**
 * Changes the IpToCountry.csv file as downloaded
 * (after taking away the portions following the # and any empty lines)
 * from http://software77.net/cgi-bin/ip-country/geo-ip.pl
 * to a tab separated file usable by MySQL
 */

import java.io.*;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoSecond{

    public static boolean isLoginPassword(String str){

        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[\\s\\S]{8,32}$";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        return m.matches();
    }
    public static void main(String[] args) {
        // 要验证的字符串

        String str = "asd64Q";
        System.out.println(isLoginPassword(str));

       /* String str = "1a2b3c4d4AS";
       // String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[\\s\S]{8,32}$";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());*/
    }
}