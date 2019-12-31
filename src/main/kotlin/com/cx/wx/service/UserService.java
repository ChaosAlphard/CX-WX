package com.cx.wx.service;

import com.cx.wx.dto.Dto;
import com.cx.wx.model.User;
import com.cx.wx.model.wxreceive.UserInfo;

public interface UserService {
    String getUserInfo(String code);

    boolean updateUser(
        String name,
        String avatar,
        String openid
    );

    User findByOpenid(String openid);
}
