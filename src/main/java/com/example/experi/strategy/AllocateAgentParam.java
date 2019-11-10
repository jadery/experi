package com.example.experi.strategy;

import lombok.Data;

@Data
public class AllocateAgentParam {

    //优先级，账号>名称>策略

    private String agentAccount;

    private String agentName;

    private String productCode;

    private String companyCode;

    private String userId;

    private String strategy = "";

    private String strategySuffix;

}
