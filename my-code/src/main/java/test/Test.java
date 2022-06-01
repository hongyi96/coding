package test;

import java.util.Calendar;
import java.util.concurrent.CountDownLatch;

public class Test {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        long method = method(countDownLatch);
        System.out.println(method);
        method = errorMethod(countDownLatch);
        System.out.println(method);
    }

    public static long method(CountDownLatch countDownLatch) {

        try {
            countDownLatch.countDown();
            return countDownLatch.getCount();
        } catch (Exception e) {

        }
        countDownLatch.countDown();
        return countDownLatch.getCount();
    }

    public static long errorMethod(CountDownLatch countDownLatch) {

        try {
            int a = 1 / 0;
            countDownLatch.countDown();
            return countDownLatch.getCount();
        } catch (Exception e) {

        }
        countDownLatch.countDown();
        return countDownLatch.getCount();
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
