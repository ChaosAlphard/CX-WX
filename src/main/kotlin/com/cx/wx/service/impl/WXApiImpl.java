package com.cx.wx.service.impl;

import com.cx.wx.cache.AccessTokenCache;
import com.cx.wx.service.WXApiService;
import com.cx.wx.util.HttpUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WXApiImpl implements WXApiService {
    private Log log = LogFactory.getLog(WXApiImpl.class);

    private AccessTokenCache cache = new AccessTokenCache();

    @Override
    public <T> T getSubscribeMessage(String openid, String templateid, Object msgData, Class<T> clazz) {
        Map<String, Object> data = initParam(openid, templateid);
        data.put("data", msgData);

        return HttpUtil.sendPost(getSubUrl(), data, clazz).getBody();
    }

    @Override
    public <T> T getSubscribeMessage(String openid, String templateid, String page, Object msgData, Class<T> clazz) {
        Map<String, Object> data = initParam(openid, templateid);
        data.put("page", page);
        data.put("data", msgData);

        return HttpUtil.sendPost(getSubUrl(), data, clazz).getBody();
    }

    private Map<String, Object> initParam(String openid, String templateid) {
        Map<String, Object> map = new HashMap<>();
        map.put("touser", openid);
        map.put("template_id", templateid);
        return map;
    }

    @NotNull
    private String getSubUrl() {
        return String.format(
            "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=%s",
            cache.getAccessTokenCache()
        );
    }

    private List<String> params(String ...args) {
        List<String> lis = new ArrayList<>();
        for (String s : args) {
            System.out.println(s);
            lis.add(s);
        }
        return lis;
    }
}
