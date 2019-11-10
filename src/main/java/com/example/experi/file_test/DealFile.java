package com.example.experi.file_test;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.*;

public class DealFile {


    public static void main(String[] args) {

        File file = new File("C:\\Users\\fidoqin\\Desktop\\商户号.txt");
        File wxwork_extend = new File("C:\\Users\\fidoqin\\Desktop\\wxwork_extend.txt");

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String thisLine = null;
            int num = 1;
            //商户号map list GuideIds\t agentAccount
            Map<String, List<String>> payIdMapGuide = new HashMap<>();
            while ((thisLine = in.readLine()) != null){
                String[] split = thisLine.split("\t");
                System.out.println(num ++ +" => " + split[0] + "=>" + split[1]);
                JSONObject jsonObject = JSONObject.parseObject(split[1]);
                jsonObject.forEach((key, value) -> {
                    List<String> guideid_account = payIdMapGuide.get(key);

                    if(CollectionUtils.isEmpty(guideid_account)){
                        List<String> new_guideid_account = new ArrayList<>();
                        new_guideid_account.add(value+"\t"+ split[0]);
                        payIdMapGuide.put(key,new_guideid_account);
                    }else {
                        guideid_account.add(value+"\t"+ split[0]);
                        payIdMapGuide.put(key,guideid_account);
                    }
                });
            }

            in.close();

            BufferedReader in1 = new BufferedReader(new InputStreamReader(new FileInputStream(wxwork_extend)));

            String this1Line = null;
            Map<String,String> accountMapWxPayUrl = new HashMap<>();
            while ((this1Line = in1.readLine()) != null){
                String[] split = this1Line.split("\t");
                accountMapWxPayUrl.put(split[0],split[1] + "\t" + split[2]);
            }


            File file1 = new File("C:\\Users\\fidoqin\\Desktop\\uuu.txt");
            File file2 = new File("C:\\Users\\fidoqin\\Desktop\\noid.txt");

            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer1 = new StringBuffer();
            Set<String> noid = new HashSet<>();
            payIdMapGuide.forEach((shanghuhao, gideids) -> {
                for(String gideid: gideids){
                    stringBuffer.append(shanghuhao).append("\t").append(gideid);

                    String[] gideId_account = gideid.split("\t");


                    if(accountMapWxPayUrl.containsKey(gideId_account[1])){
                        String wxPayQrcodeUrl = accountMapWxPayUrl.get(gideId_account[1]);
                        stringBuffer.append("\t").append(wxPayQrcodeUrl);
                    }else {
                        System.out.println(gideId_account[1] + "查不到");
                        stringBuffer.append("\t").append("无");
                        noid.add(gideId_account[1]);
                    }

                    stringBuffer.append(System.getProperty("line.separator"));
                }
            });

            noid.forEach(value -> stringBuffer1.append(value).append(","));


            try {
                FileWriter fileWriter = new FileWriter(file1);

                fileWriter.write(stringBuffer.toString());

                FileWriter fileWriter1 = new FileWriter(file2);

                fileWriter1.write(stringBuffer1.toString());
                fileWriter1.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
