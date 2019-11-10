package com.example.experi.thread_test;

import com.example.experi.service.ThreadService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ThreadLocalTest {

    @Autowired
    private ThreadService threadService;

    @Test
    public void test_local(){

        threadService.print();

    }


}
