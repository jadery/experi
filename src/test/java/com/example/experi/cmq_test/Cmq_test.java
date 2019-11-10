package com.example.experi.cmq_test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Cmq_test {

    @Autowired
    private CmqService cmqService;

    private static final String defalut_directory = "testjson/";

    private static final String defalut_file_suffix = ".json";


    public String getFileJsonStr(String fileName){
        try {
            return FileUtils.readFileToString(ResourceUtils.getFile("classpath:" + defalut_directory + fileName + defalut_file_suffix));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Test
    public void tms_addv_send_test(){

        String addvJson = getFileJsonStr("AddvJson");
        System.out.println(addvJson);

        cmqService.sendCmq("Q-SUB-TMS-WXWORK-SIT",addvJson);

    }

    /**
     * 监控h5成交对别静默开白
     */
    @Test
    public void h5_order_status_change_test(){
        String h5orderStr = getFileJsonStr("H5OrderChange");

        cmqService.sendCmq("Q-SUB-WIMVIP-ORDERPAY-DEV",h5orderStr);
    }


    /**
     * tms 企业微信消息测试
     */
    @Test
    public void test_tms_chart_msg(){

        String chartMsg = getFileJsonStr("ChartMsg");

        cmqService.sendCmq("Q-SUB-WIMVIP-WX-MSG-SYN-SIT",chartMsg);

    }

}
