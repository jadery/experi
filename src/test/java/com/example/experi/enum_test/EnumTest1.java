package com.example.experi.enum_test;

import com.example.experi.enums.FamilyRoleEnum;
import com.example.experi.enums.WorkWxMsgTypeEnum;
import org.junit.Test;

public class EnumTest1 {

    @Test
    public void test_allType() {

        String aaa = "TEXT";

        try {

            WorkWxMsgTypeEnum workWxMsgTypeEnum = WorkWxMsgTypeEnum.valueOf(aaa);

            WorkWxMsgTypeEnum[] values = WorkWxMsgTypeEnum.values();
            for(int i=0; i<values.length; i++){
                System.out.println(values[i]);

            }

            System.out.println(workWxMsgTypeEnum);
        }catch (IllegalArgumentException e){
            System.out.println(666);
        }


    }

    @Test
    public void test_enu(){
        String type = "text";
        String value = WorkWxMsgTypeEnum.TEXT.getValue();
        System.out.println(value);

        if(WorkWxMsgTypeEnum.TEXT.getValue().equalsIgnoreCase(type)){
            System.out.println(66);
        }
    }

    @Test
    public void test_enuu(){
        String name = FamilyRoleEnum.getName(1);

        System.out.println(name);
    }




}
