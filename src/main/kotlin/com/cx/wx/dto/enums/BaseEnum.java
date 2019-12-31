package com.cx.wx.dto.enums;

import org.jetbrains.annotations.Contract;

public enum BaseEnum {
    GET_DATA_SUCCESS(200,"ok"),
    INSERT_SUCCESS(200,"ok"),
    UPDATE_SUCCESS(200,"ok"),
    SEND_MESSAGE_SUCCESS(200, "ok"),

    LOST_PARAM(400,"参数丢失"),
    NOT_FOUND(404,"找不到对应数据"),

    GET_DATA_FAIL(500, "获取数据失败"),
    SQL_ERROR(500,"SQL异常"),
    INSERT_FAIL(500,"插入失败"),
    UPDATE_FAIL(500,"更新失败"),
    SEND_MESSAGE_FAIL(500, "发送失败")
    ;

    private int code;
    private String msg;

    BaseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Contract(pure = true)
    public int getCode() {
        return code;
    }

    @Contract("_ -> this")
    public BaseEnum setCode(int code) {
        this.code = code;
        return this;
    }

    @Contract(pure = true)
    public String getMsg() {
        return msg;
    }

    @Contract("_ -> this")
    public BaseEnum setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
