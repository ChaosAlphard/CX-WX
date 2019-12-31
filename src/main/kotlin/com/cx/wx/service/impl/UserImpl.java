package com.cx.wx.service.impl;

import com.cx.wx.cache.AppSettings;
import com.cx.wx.dao.UserDao;
import com.cx.wx.model.User;
import com.cx.wx.model.wxreceive.UserInfo;
import com.cx.wx.service.UserService;
import com.cx.wx.util.HttpUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserImpl implements UserService {
    private Log log = LogFactory.getLog(UserImpl.class);
    private final String idAndSecret = AppSettings.getIdAndSecret();

    @Resource
    private UserDao ud;

    @Override
    public String getUserInfo(String code) {
        String url = String.format(
        "https://api.weixin.qq.com/sns/jscode2session?%s&js_code=%s&grant_type=authorization_code",
            idAndSecret, code
        );

        try {
            return HttpUtil.sendGet(url, String.class).getBody();
        } catch (Exception e) {
            log.error("UserImpl@getUserInfo:Err: ", e);
            return null;
        }
    }

    @Override
    public boolean updateUser(String name, String avatar, String openid) {
        try {
            User usr = findByOpenid(openid);
            int i;
            if(usr!=null) {
                i = ud.updateUser(name,avatar,openid);
            } else {
                i = ud.insertUser(name,avatar,openid);
            }

            return i != 0;
        } catch (Exception e) {
            log.error("插入/更新失败", e);
            return false;
        }
    }

    @Nullable
    public User findByOpenid(String openid) {
        User usr;
        try {
            usr = ud.findByOpenid(openid);
        } catch (Exception e) {
            log.error("SQL执行失败", e);
            return null;
        }
        if (usr!=null && usr.getName() != null) {
            return usr;
        } else {
            return null;
        }
    }
}
