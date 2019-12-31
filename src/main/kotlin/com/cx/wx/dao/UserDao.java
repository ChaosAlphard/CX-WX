package com.cx.wx.dao;

import com.cx.wx.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User findByOpenid(@Param("openid") String openid);

    int insertUser(
        @Param("name") String name,
        @Param("avatar") String avatar,
        @Param("openid") String openid
    );

    int updateUser(
        @Param("name") String name,
        @Param("avatar") String avatar,
        @Param("openid") String openid
    );
}
