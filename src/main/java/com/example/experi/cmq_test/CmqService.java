package com.example.experi.cmq_test;

import cn.wesure.cmq.CmqTemplate;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CmqService {

    @Autowired
    private CmqTemplate cmqTemplate;

    public void sendCmq(String queueName, String cmqMsg) {
        try {
            cmqTemplate.sendQueue(queueName,cmqMsg);
        } catch (Exception e) {
            System.out.println("发送消息错误");
            e.printStackTrace();
        }
    }



    public void sendCmqJson(String queueName, JSONObject cmqJson) {
        try {
            cmqTemplate.sendQueue(queueName,cmqJson.toJSONString());
        } catch (Exception e) {
            System.out.println("发送 json 消息错误");
            e.printStackTrace();
        }
    }


}
