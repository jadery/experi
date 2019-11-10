package com.example.experi.date_test;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Slf4j
public class DateUtils {

    public final  static String DATE_FORMATE_1 = "yyyy-MM-dd HH:mm:ss";

    public final  static String DATE_FORMATE_2 = "yyyyMM";

    public final  static String DATE_FORMATE_3 = "yyyy-MM-dd";

    public static String parseByFormate(long date, String formate){
        return new SimpleDateFormat(formate).format(new Date(date));
    }

    public static String parseByFormate(Date date, String formate){
        return new SimpleDateFormat(formate).format(date);
    }

    public static Date parse(String data)  {

        try {
            Date rs = new SimpleDateFormat(DATE_FORMATE_1).parse(data);
            return rs;
        } catch (ParseException e) {
            log.error("日期格式不标准转换失败");
        }
        return null;
    }

    public static String parse(long data) {
        return new SimpleDateFormat(DATE_FORMATE_1).format(new Date(data));
    }

    public static String parse(Date date){
        return new SimpleDateFormat(DATE_FORMATE_1).format(date);
    }


    public static Date parse(String data,String dateFormate)  {

        try {
            Date rs = new SimpleDateFormat(dateFormate).parse(data);
            return rs;
        } catch (ParseException e) {
            log.error("日期格式不标准,转换失败");
        }
        return null;
    }

    public static Date changeDayTime(Date date, int offset){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, offset);
        return calendar.getTime();
    }

}
