/*
public class TimeDemo03 {

    public static void main(String[] args){
        System.err.println("Hello");

    }

    public static String formate(Date time) {
        return formate(time, "yyyy/MM/dd HH:mm:ss");
    }

    public static String formate(Date time, String partten) {
        if (time == null || StringUtils.isEmpty(partten)) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(partten);
        // sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        String formateTime = sdf.format(time);
        return formateTime;
    }
}
*/
