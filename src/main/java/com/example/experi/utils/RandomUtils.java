package com.example.experi.utils;

import java.util.List;
import java.util.Random;

public class RandomUtils {



    public static <T> T getOne(List<T> list){

        Random random = new Random();

        if(list == null || list.size() == 0){
            return null;
        }

        int i = random.nextInt(list.size());

        return list.get(i);
    }

}
