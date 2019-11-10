package com.example.experi.collection_test;

import com.alibaba.fastjson.JSONObject;
import com.example.experi.domain.jsonToMap.JsonToMap;
import com.example.experi.utils.JsonUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class Map_test {


    /**
     * 测试 json中info 字段转map
     * 结果 可以转成功
     */
    @Test
    public void test_json_map(){

        String jsonToMapStr = JsonUtils.getFileJsonStr("JsonToMap");

        JSONObject jsonObject = JSONObject.parseObject(jsonToMapStr);

        JsonToMap jsonToMap = JSONObject.toJavaObject(jsonObject, JsonToMap.class);

        System.out.println(jsonToMap);

        List<BigDecimal> value = jsonToMap.getData().getValue();
        value.forEach( val -> {
            System.out.println(val);
            System.out.println(val.toString());
        });
        System.out.println(666);

    }


}
