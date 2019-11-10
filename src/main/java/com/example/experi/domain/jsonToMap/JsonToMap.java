package com.example.experi.domain.jsonToMap;

import lombok.Data;

import java.util.Map;

@Data
public class JsonToMap {

    private JsonToMapBase base;

    private Map<String,String> info;

    private JsonToMapData data;

}
