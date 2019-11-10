package com.example.experi.json_test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.experi.domain.Student;
import org.junit.Test;

public class JsonTest {

    /**
     * 测试json对象put重复key值是否覆盖
     * 是
     */
    @Test
    public void json_test(){
        String testaa = "{\"userid\":\"123\",\"username\":\"rrrr\"}";
        JSONObject jsonObject = JSONObject.parseObject(testaa);

        System.out.println(jsonObject);
        jsonObject.put("userid","uiop");

        System.out.println(jsonObject);

    }

    /**
     * 测试空字符是否可以转换为 json对象
     * 否
     */
    @Test
    public void json_test1(){
        String testaa = "";
        JSONObject jsonObject = JSONObject.parseObject(testaa);

        System.out.println(jsonObject);
        jsonObject.put("userid","uiop");

        System.out.println(jsonObject);

    }

    /**
     * 测试 java 对象转json String
     */
    @Test
    public void json_test2(){

        Student student = new Student(777,"小明");
        System.out.println(student);
        String sout = JSONObject.toJSONString(student);

        System.out.println(sout);

    }

    /**
     * 测试 json字符串转 java对象
     */
    @Test
    public void json_test3(){

        String userStr = "{\"userId\":777,\"userName\":\"小明\"}";

        Student student = JSONObject.toJavaObject(JSONObject.parseObject(userStr), Student.class);

        System.out.println(student);


    }

    @Test
    public void test_json_array(){

        String arrayTest = "[\"这个方案描述就是好（特色1）\",\"新增的本人方案特色（特色2）\"]";

        JSONArray objects = JSONArray.parseArray(arrayTest);

        System.out.println(objects);

        objects.forEach( itemStr -> System.out.println(itemStr));
    }

}
