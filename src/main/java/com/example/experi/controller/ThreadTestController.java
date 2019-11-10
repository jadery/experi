package com.example.experi.controller;

import com.example.experi.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thread")
public class ThreadTestController {

    @Autowired
    private ThreadService threadService;

    @GetMapping("/aaa")
    public void test(String aaa){
        ThreadService.add(aaa);
        threadService.print();
    }


}
