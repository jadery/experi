package com.example.experi.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;

import java.io.IOException;

public class JsonUtils {


    private static final String defalut_directory = "testjson/";

    private static final String defalut_file_suffix = ".json";


    public static String getFileJsonStr(String fileName){
        try {
            return FileUtils.readFileToString(ResourceUtils.getFile("classpath:" + defalut_directory + fileName + defalut_file_suffix));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
