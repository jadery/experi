package com.example.experi.str_test;

import com.example.experi.domain.FamilyRoleBean;
import com.example.experi.enums.FamilyRoleEnum;
import com.example.experi.utils.ProductConfigUtils;
import com.example.experi.utils.RandomUtils;
import org.junit.Test;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringTest {

    @Test
    public void test_replace(){

        String test = "我是你的微管家$$, 有问题加我企业微信";

        String replace = "";

        if(test.contains("$$")){
             replace = test.replace("$$", "唐家倪");
        }
        System.out.println(test);
        System.out.println(replace);
    }


    @Test
    public void test_replace1(){

        String test = "小明打算";

        char[] chars = test.toCharArray();

        if(chars.length == 2){
            System.out.println(test.replaceFirst(test.substring(1),"*"));
        }else if(chars.length > 2){
            System.out.println(test.replaceAll(test.substring(1, chars.length-1), "*"));
        }

        System.out.println(test);
    }

    @Test
    public void test_sort(){

        List<String> names = new ArrayList<>();

        names.add("子女1");
        names.add("子女2");
        names.add("子女5");
        names.add("子女6");
        names.add("子女3");
        names.add("子女7");
        names.add("子女8");
        names.add("子女4");
        names.add("子女9");
        names.add("子女10");
        names.add("本人");
        names.add("配偶");
        names.add("父亲");
        names.add("母亲");
        names.add("配偶父亲");
        names.add("配偶母亲");

        List<FamilyRoleBean> newNames = new ArrayList<>();
        List<FamilyRoleBean> roleBeans = new ArrayList<>();
        List<FamilyRoleBean> childBeans = new ArrayList<>();
        names.forEach( name -> {

            if("本人".equalsIgnoreCase(name)){
                newNames.add(new FamilyRoleBean(name,6));
            }else if(!name.contains("子女")){

                Integer type = FamilyRoleEnum.getType(name);
                roleBeans.add(new FamilyRoleBean(name,type));
            }else {
                childBeans.add(new FamilyRoleBean(name,Integer.parseInt(name.substring(2))));
            }

        });

        Collections.sort(roleBeans);
        Collections.sort(childBeans);

        System.out.println("------------------");
        System.out.println(newNames);
        System.out.println(roleBeans);
        System.out.println(childBeans);
        System.out.println("------------------");

    }


    @Test
    public void test_sub(){

        String nums = "6000000";

        System.out.println(nums.substring(0,nums.length()-4));

        String name = ProductConfigUtils.Modx.SINGLE.name();

        System.out.println(name);

    }

    /**
     * list 转 string
     */
    @Test
    public void test_list_tostring(){
        List<String> names = new ArrayList<>();

        names.add("子女1");
        names.add("子女2");
        names.add("子女5");

        String string = StringUtils.collectionToCommaDelimitedString(names);

        System.out.println(string);
    }

    @Test
    public void test_string_to_list(){
        String aaa = "xiaoming,huahua,66666";

        List<String> list = CollectionUtils.arrayToList(aaa.split(","));

        for (int i=0; i<10; i++){
            System.out.println(RandomUtils.getOne(list));
        }


    }


}
