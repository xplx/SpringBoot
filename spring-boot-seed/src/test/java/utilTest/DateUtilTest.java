package utilTest;

import cn.hutool.core.date.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * @author wuxiaopeng
 * @description: 时间类测试
 * @date 2020/1/21 11:14
 */
public class DateUtilTest {
    public static void main(String[] args) {
        getNowTime();
    }

    private static void getNowTime(){
        //当前时间
        Date date = DateUtil.date();
        System.out.println("date:"+ date);
        //当前时间
        Date date2 = DateUtil.date(Calendar.getInstance());
        System.out.println("date2:"+ date2);
        //当前时间
        Date date3 = DateUtil.date(System.currentTimeMillis());
        System.out.println("date3:"+ date3);
        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        System.out.println("now:"+ now);
        //当前日期字符串，格式：yyyy-MM-dd
        String today = DateUtil.today();
        System.out.println("today:"+ today);
        System.out.println( DateUtil.thisDayOfWeekEnum());
    }
}

