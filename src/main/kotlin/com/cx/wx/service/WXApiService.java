package com.cx.wx.service;

public interface WXApiService {
    <T> T getSubscribeMessage(
            String openid,
            String templateid,
            Object msgData,
            Class<T> clazz
    );

    <T> T getSubscribeMessage(
            String openid,
            String templateid,
            String page,
            Object msgData,
            Class<T> clazz
    );
}
