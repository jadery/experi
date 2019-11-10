package com.example.experi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Value("#{'${wxpay.mchid}'.split(',')}")
    private List<String> mchids;

    @Value("#{'${wxpay.test}'.split(',')}")
    private List<String> mchid;

    public void test(){

        System.out.println(mchids);
        System.out.println(mchid);
        System.out.println(666);

    }


}
