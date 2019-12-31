package com.cx.wx.dto;

import com.cx.wx.dto.enums.BaseEnum;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Dto<T> {
    private int code;
    private String msg;
    private T model;
    private List<T> data;

    public Dto(@NotNull BaseEnum be) {
        this.code = be.getCode();
        this.msg = be.getMsg();
    }

    public Dto(@NotNull BaseEnum be, T model) {
        this.code = be.getCode();
        this.msg = be.getMsg();
        this.model = model;
    }

    public Dto(@NotNull BaseEnum be, List<T> data) {
        this.code = be.getCode();
        this.msg = be.getMsg();
        this.data = data;
    }

    public Dto(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Dto(int code, String msg, T model) {
        this.code = code;
        this.msg = msg;
        this.model = model;
    }

    public Dto(int code, String msg, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getModel() {
        return model;
    }

    public List<T> getData() {
        return data;
    }
}
