package com.cx.wx.service;

public interface WXApiService {
    /**
     * 推送订阅消息
     * @param openid 推送给的用户
     * @param templateid 推送的消息模板
     * @param msgData 推送的消息内容
     * @param clazz 返回结果反序列化的java类
     * @return 返回结果
     */
    <T> T getSubscribeMessage(
            String openid,
            String templateid,
            Object msgData,
            Class<T> clazz
    );

    /**
     * 推送带跳转的订阅消息
     * @param openid 推送给的用户
     * @param templateid 推送的消息模板
     * @param page 跳转的页面路径
     * @param msgData 推送的消息内容
     * @param clazz 返回结果反序列化的java类
     * @return 返回结果
     */
    <T> T getSubscribeMessage(
            String openid,
            String templateid,
            String page,
            Object msgData,
            Class<T> clazz
    );
}
