package com.example.experi.date_test;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;

public class DateTest {

    @Test
    public void date_pase_test(){
        String date = "2019-07-23";
        Date parse = DateUtils.parse(date,DateUtils.DATE_FORMATE_3);
        String datea = DateUtils.parseByFormate(parse, DateUtils.DATE_FORMATE_3);

        System.out.println(666);
    }

    @Test
    public void date_pase_test_1(){

        long payTime = 1534331901000L;

        long time = new Date().getTime();

        System.out.println(time);
        System.out.println(DateUtils.parse(time));
        System.out.println(payTime);
        System.out.println(DateUtils.parse(payTime));


        System.out.println(time - payTime);
        long day30 = 1000L * 60 * 60 * 24 * 30;
        System.out.println(day30);
        System.out.println();

        System.out.println(666);
    }

    @Test
    public void date_compare(){

        Date date = new Date();

        Date date1 = new Date(System.currentTimeMillis() + 5000);

        System.out.println(DateUtils.parse(date));

        System.out.println(DateUtils.parse(date1));

        System.out.println(date.compareTo(date));
        System.out.println(date.compareTo(date1));
        System.out.println(date1.compareTo(date));
    }

}
