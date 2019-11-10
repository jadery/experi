package com.example.experi.num_test;

import org.junit.Test;

import java.math.BigDecimal;

public class NumTest {


    @Test
    public void num_test1(){
        Integer num = 2250003;
        BigDecimal bigDecimal = new BigDecimal(num);
        BigDecimal divide = bigDecimal.divide(new BigDecimal(100));
        String nums = divide.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue() + "";
        System.out.println(nums);
        if(nums.endsWith(".0")){
            String replace = nums.replace(".0", "");
            System.out.println(replace);
        }
    }

    @Test
    public void num_test2(){

        BigDecimal bigDecimal = new BigDecimal(32.00);
        System.out.println(bigDecimal.toString());
    }

    @Test
    public void num_test3(){
        BigDecimal bigDecimal = new BigDecimal(10);

        BigDecimal divide = bigDecimal.divide(new BigDecimal(8),4,BigDecimal.ROUND_HALF_UP);

        System.out.println(divide.doubleValue());
    }

    @Test
    public void num_test4(){
        BigDecimal bigDecimal = new BigDecimal(32.23456);

        BigDecimal bigDecimal1 = bigDecimal.setScale(3, BigDecimal.ROUND_HALF_UP);


        System.out.println(bigDecimal.toString());
        System.out.println(bigDecimal1.toString());
    }

    @Test
    public void num_test5(){
        BigDecimal bigDecimal = new BigDecimal("3704");

        System.out.println(bigDecimal.toString());

        BigDecimal divide = bigDecimal.divide(new BigDecimal(100));

        System.out.println(divide);
    }

}
