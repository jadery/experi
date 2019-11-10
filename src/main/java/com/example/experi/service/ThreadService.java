package com.example.experi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ThreadService {

    private static final ThreadLocal<String> account = new ThreadLocal<>();

    @Autowired
    private TestService testService;

    public static void add(String aaa){
        account.set(aaa);
    }

    public static String get(){
        return account.get();
    }

    public static void remove(){
        account.remove();
    }


    public void print(){
        log.info("[{}] account:{} => hashCode:{}",account,account.get(),account.hashCode());
        log.info("testService:{}, hashCode:{}",testService,testService.hashCode());
    }

}
