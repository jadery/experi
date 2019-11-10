package com.example.experi.enums;

public enum WorkWxMsgTypeEnum {

    /**
     * 文本消息
     */
    TEXT("text"),

    /**
     * 图片消息
     */
    IMAGE("image"),

    /**
     * 图文消息
     */
    LINK("link"),

    /**
     * 小程序
     */
    MINIPROGRAM("miniprogram")
    ;

    private String value;

    public String getValue() {
        return value;
    }

    WorkWxMsgTypeEnum(String value) {
        this.value = value;
    }

}
