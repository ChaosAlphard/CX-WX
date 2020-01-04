package com.cx.wx.cache;

import com.alibaba.fastjson.JSON;
import com.cx.wx.model.AccessToken;
import com.cx.wx.util.DateUtil;
import com.cx.wx.util.HttpUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;

public class AccessTokenCache {
    private static final String idAndSecret = AppSettings.getIdAndSecret();
    private static final String getTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?" +
            "grant_type=client_credential&"+ idAndSecret;

    private String accessToken = null;
    // token 过期时间
    private Long expiresTime = null;

    private Log log = LogFactory.getLog(AccessTokenCache.class);

    /**
     * 将AccessToken暴露给外部
     * @return (String) AccessToken
     */
    public String getAccessTokenCache() {
        if(this.accessToken!=null&&this.isTokenValid()){
            return this.accessToken;
        }
        AccessToken token = this.getAccessToken();
        this.setCache(token);
        log.info("获取Token成功, 失效时间: "+
            DateUtil.date2Str(DateUtil.timeSecond2Date(this.expiresTime))
        );

        return this.accessToken;
    }

    /**
     * 从腾讯API获取AccessToken
     * @return AccessToken
     */
    private AccessToken getAccessToken() {
        return HttpUtil.sendGet(getTokenUrl, AccessToken.class).getBody();
    }

    /**
     * 将获取到的token缓存起来
     * @param token AccessToken
     */
    private void setCache(@NotNull AccessToken token) {
        this.accessToken = token.getAccess_token();
        int expires = token.getExpires_in() - 600;   //10*60s 提前10min申请accessToken
        Long current = DateUtil.getCurrentSecond();
        this.expiresTime = current + expires;
    }

    /**
     * 判断Token是否有效
     * @return 是(true)否(false)有效
     */
    private boolean isTokenValid() {
        if(this.expiresTime == null || this.expiresTime < 0L) {
            return false;
        }
        boolean isValid = this.expiresTime > DateUtil.getCurrentSecond();
        if(isValid) {
            log.info("Token有效");
        } else {
            log.info("Token失效");
        }
        return isValid;
    }
}
