package com.example.experi.collection_test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class List_test {

    /**
     * list 合并到 set
     */
    @Test
    public void set_list_merge(){

        Set<String> userIds = new HashSet<>();
        userIds.add("aaa");
        userIds.add("bbb");
        System.out.println(userIds);
        List<String> userIdds = new ArrayList<>();
        userIdds.add("bbb");
        userIdds.add("ccc");
        userIdds.add("ddd");
        System.out.println(userIdds);

        userIds.addAll(userIdds);

        System.out.println(userIds);

        System.out.println(userIdds);

    }

    @Test
    public void test_merge(){

        List<String> aa = new ArrayList<>();

        List<String> bb = null;

        aa.addAll(bb);

    }


}
