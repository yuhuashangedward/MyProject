package com.alibaba.demo.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CommonUtil {

    private static String CODES = "01234567890abcdefghijklmnopqrstuvwxyz";

    /**
     * 递归生成随机码，按传入位数递归
     * @param sum
     * @return
     */
    public static String randCode(String code,int sum){
        if(code.length()>=sum){
            return code;
        }
        if(sum<=0){
            return code;
        }
        java.util.Random random = new java.util.Random();
        int result=random.nextInt(10);
        code += result;
        return randCode(code,sum--);
    }

    /**
     * 递归生成随机串
     * @param code 初始化为""
     * @param sum
     * @return
     */
    public static String randString(String code,int sum){
        if(code.length()>=sum){
            return code;
        }
        if(sum<=0){
            return code;
        }
        char[] code_s = CODES.toCharArray();
        java.util.Random random=new java.util.Random();
        int result=random.nextInt(CODES.length());
        code += code_s[result];
        return randString(code,sum--);
    }

    public static String EncoderByMd5(String content){
        // 生成一个MD5加密计算摘要
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(content.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5加密出现错误");
        }
    }

    /**
     * 整数化处理
     * @param num
     */
    public static BigDecimal integerize(BigDecimal num){
        long l = num.longValue();
        return new BigDecimal(l);
    }


    /**
     * 保留两位小数
     * @param args
     */
    public static double getTwoDecimal(double num){
        BigDecimal b = new BigDecimal(num+"");
        double f = b.setScale(2, BigDecimal.ROUND_HALF_EVEN).doubleValue();
        return f;
    }

    /**
     * 保留小数位数
     * @param args
     */
    public static double scaleDecimal(double num,int scale){
        if(scale<0)scale=0;
        BigDecimal b = new BigDecimal(num+"");
        double f = b.setScale(scale, BigDecimal.ROUND_HALF_EVEN).doubleValue();
        return f;
    }

    /**
     * int转byte[]
     * @param number
     * @return
     */
    public static byte[] intToByte(int number){
        byte[] src = new byte[4];
        src[3] =  (byte) ((number>>24) & 0xFF);
        src[2] =  (byte) ((number>>16) & 0xFF);
        src[1] =  (byte) ((number>>8) & 0xFF);
        src[0] =  (byte) (number & 0xFF);
        return src;
    }

    /**
     * byte[]转int
     * @param bytes
     * @return
     */
    public static int bytesToInt(byte[] bytes) {
        int n=0;
        for(int i=0;i<4;i++){
            n<<=8;
            n |= (bytes[4-i] & 0xff);
        }
        return n;
    }

    /**
     * long转byte[]
     * @param number
     * @return
     */
    public static byte[] longToByte(long number) {
        byte[] targets = new byte[8];
        for (int i = 0; i < 8; i++) {
            int offset = (targets.length - 1 - i) * 8;
            targets[7-i] = (byte) ((number >>> offset) & 0xff);
        }
        return targets;
    }

    /**
     * byte[]转long
     * @param args
     * @return
     */
    public static long bytesToLong(byte[] bytes) {
        long num = 0;
        for(int i=0;i<8;i++){
            num <<= 8;
            num |= (bytes[7-i] & 0xff);
        }
        return num;
    }

    /**
     * double转byte[]
     * @param number
     * @return
     */
    public static byte[] doubleToByte(double number) {
        long l = Double.doubleToLongBits(number);
        return longToByte(l);
    }

    /**
     * byte[]转double
     * @param args
     * @return
     */
    public static double bytesToDouble(byte[] bytes) {
        long l = bytesToLong(bytes);
        return Double.longBitsToDouble(l);
    }

    /**
     * 获取最大整除数
     * @param price
     * @param depth
     * @return
     */
    public static BigDecimal getMaxDivisorNumber(BigDecimal dividend,int divisor){
        if(dividend == BigDecimal.ZERO){
            return dividend;
        }
        BigDecimal num = dividend .subtract(dividend . divideAndRemainder(new BigDecimal(divisor))[1]);
        return num;
    }

    public static String decimalToStr(BigDecimal bd){
        if(bd==null){
            return "0";
        }else{
            return bd.stripTrailingZeros().toPlainString();
        }
    }

    /**判断两个BigDecimal的大小（忽略12位小数的差异）
     * @param b1
     * @param b2
     * @return
     */
    public static int compareDecimail(BigDecimal b1,BigDecimal b2){
        if(b1==null){
            b1 = BigDecimal.ZERO;
        }
        if(b2==null){
            b2 = BigDecimal.ZERO;
        }
        BigDecimal b3 = b1.subtract(b2);
        BigDecimal dd = new BigDecimal(1E-12);
        if(b3.compareTo(dd)>0){
            return 1;
        }else if(b3.compareTo(BigDecimal.ZERO.subtract(dd))<0){
            return -1;
        }else{
            return 0;
        }
    }

    /**
     * 根据用户ID生成特定规律的邀请串
     * @param numbers
     * @return
     */
    public static String getNumber4Char(String numbers){
        String randStr = randString("",3);
        String randCode = randString("",1);
        String rand = randCode + "_" + randStr.toUpperCase();
        StringBuffer buffer = new StringBuffer(numbers);
        return rand+buffer.reverse();
    }

    /**
     * 时间按天分割，根据时区来计算天分割节点
     * @param startTime
     * @param endTime
     * @param timeZone
     * @return
     */
    public static List<Date[]> splitDayTime(Date startTime, Date endTime, int timeZone){
        int formatTime = 24 - timeZone;
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startTime);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endTime);
        List<Date[]> list = new ArrayList<Date[]>();
        int index = 0;
        while(true){
            int startDay = startCalendar.get(Calendar.DATE) - timeZone;
            int endDay = endCalendar.get(Calendar.DATE) - timeZone;
            int startMonth = startCalendar.get(Calendar.MONTH);
            int endMonth = endCalendar.get(Calendar.MONTH);
            if(startDay == endDay){
                Date[] date = new Date[]{startCalendar.getTime(),endTime};
                list.add(date);
                break;
            }else if(startMonth<endMonth||startDay < endMonth){
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_YEAR, index);
                calendar.set(Calendar.HOUR_OF_DAY, formatTime);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);
                if(calendar.getTime().getTime()>startCalendar.getTime().getTime()){
                    Date[] date = new Date[]{startCalendar.getTime(),calendar.getTime()};
                    list.add(date);
                    startCalendar = calendar;
                }
                index ++;
            }else{
                break;
            }
        }
        return list;
    }


    public static void main(String[] args) {
        try{
            //			String content = EncoderByMd5("123");
            //			System.out.println(content);
            //			BigDecimal a = new BigDecimal("59.959059999999951");
            //			BigDecimal b = new BigDecimal("40.040940000000049");
            //			System.out.println(a.add(b));
            //			Map<String,Object> map = new HashMap<String,Object>();
            //			map.put("/swap/btc2cny.act?cmd=placeBuyRiseOrder", "123");
            //			System.out.println(map.get("/swap/btc2cny.act?cmd=placeBuyRiseOrder"));
            //			boolean a = isChinaIP(null);
            //			String a = EncoderByMd5("abc123456");
            //			System.out.println(a);
            //			long time = System.nanoTime();
            //			String a = getNumber4Char("100013");
            //			System.out.println(a);
            //			System.out.println(System.nanoTime()-time);

            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-07-02 13:10:00");
            Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-07-03 13:20:00");
            List<Date[]> list = splitDayTime(date, date1,8);
            for (Date[] dates : list) {
                System.out.println("date0>>"+dates[0]+":::date1>>"+dates[1]);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
