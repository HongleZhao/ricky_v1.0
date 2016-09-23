package com.ricky.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * Created by zhl on 16/9/22.
 */
public class DateKit {
    /**
     * 获取某一天的开始时间
     * @param startTime
     * @return
     */
    public static Date getDayStartTime(Date startTime){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date start = calendar.getTime();
        return start;
    }

    /**
     * 获取某一天的结束时间
     * @param endTime
     * @return
     */
    public static Date getDayEndTime(Date endTime){
        Calendar calendar = Calendar.getInstance();
        if(null==endTime){
            endTime = new Date();
        }
        calendar.setTime(endTime);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.SECOND, -1);
        Date end = calendar.getTime();
        return end;
    }

    /**
     * 根据指定格式解析字符串为日期
     * @param time
     * @param pattern
     * @return
     */
    public static Date String2Date(String time, String pattern) {
        if (time == null) return null;
        SimpleDateFormat sf=new SimpleDateFormat(pattern);
        Date times = null;
        try {
            times = sf.parse(time);
        } catch (ParseException e) {
        }
        return times;
    }

    /**
     * 返回yyyy-MM-dd HH:mm:ss格式的字符串
     * @param date
     * @return
     */
    public static String getFormatDateString(Date date) {
        String s = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date);
        return s;
    }

    /**
     * 在日期基础山增加指定天数返回
     * @param date
     * @param day
     * @return
     */
    public static Date addDay(Date date,int day){
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR,day);
        return cal.getTime();
    }

    /**
     * 在日期基础山增加指定分钟返回
     * @param date
     * @param minute
     * @return
     */
    public static Date addMinute(Date date,int minute){
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE,minute);
        return cal.getTime();
    }

    /**
     * 在日期基础山增加指定秒返回
     * @param date
     * @param second
     * @return
     */
    public static Date addSecond(Date date,int second){
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND,second);
        return cal.getTime();
    }
}
