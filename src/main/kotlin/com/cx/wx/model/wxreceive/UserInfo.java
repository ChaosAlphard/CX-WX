package com.cx.wx.model.wxreceive;

import org.jetbrains.annotations.Contract;

import java.util.Objects;

public class UserInfo {
    private String session_key;
    private String openid;

    public String getSession_key() {
        return session_key;
    }

    public UserInfo setSession_key(String session_key) {
        this.session_key = session_key;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public UserInfo setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "session_key='" + session_key + '\'' +
                ", openid='" + openid + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(session_key, openid);
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(session_key, userInfo.session_key) &&
                Objects.equals(openid, userInfo.openid);
    }
}
