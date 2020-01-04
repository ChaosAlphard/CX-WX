package com.cx.wx.service;

import com.cx.wx.dto.Dto;
import com.cx.wx.model.User;
import com.cx.wx.model.wxreceive.UserInfo;

public interface UserService {
    /**
     * 通过openid查询用户信息(微信数据库)
     * @param code openid
     * @return 用户信息json字符串
     */
    String getUserInfo(String code);

    /**
     * 插入/更新用户
     * @param name 名称
     * @param avatar 头像
     * @param openid openid
     * @return 插入/更新是否成功
     */
    boolean updateUser(
        String name,
        String avatar,
        String openid
    );

    /**
     * 通过openid查询用户信息(本地数据库)
     * @param openid openid
     * @return 用户对象
     */
    User findByOpenid(String openid);
}
