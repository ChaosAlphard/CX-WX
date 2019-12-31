package com.cx.wx.cache;

import org.jetbrains.annotations.Contract;

public class AppSettings {
    private final static String appId = "wx8a3e8bf03782398e";
    private final static String appSecret = "2c41233c37b9de2d2eb31af2e75964f8";
    private final static String idAndSecret = "appid="+appId+"&secret="+appSecret;

    @Contract(pure = true)
    public static String getAppId() {
        return appId;
    }

    @Contract(pure = true)
    public static String getAppSecret() {
        return appSecret;
    }

    @Contract(pure = true)
    public static String getIdAndSecret() {
        return idAndSecret;
    }
}
