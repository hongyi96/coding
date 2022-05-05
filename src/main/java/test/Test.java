package test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Calendar;

public class Test {
    public static void main(String[] args) {
        String s="%E8%BD%BB%E5%A5%A2%E5%8D%AB%E7%94%9F%E9%97%B4";
        String s1="汉字";
        try {
            System.out.println(URLDecoder.decode(s,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(URLDecoder.decode(s1));
    }

    public static long getSecondsNextEarlyMorning() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        // 改成这样就好了
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000;
    }

    public static long getSecondsToday(int hour) {
        Calendar cal = Calendar.getInstance();

        // 到几点的时间
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000;
    }
}
