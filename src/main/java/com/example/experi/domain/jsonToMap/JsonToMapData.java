package com.example.experi.domain.jsonToMap;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class JsonToMapData {

    private String name;

    private List<BigDecimal> value;

}
