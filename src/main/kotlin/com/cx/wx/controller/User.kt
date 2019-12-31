package com.cx.wx.controller

import com.cx.wx.cache.AppSettings
import com.cx.wx.dto.Dto
import com.cx.wx.dto.enums.BaseEnum
import com.cx.wx.service.impl.UserImpl
import com.cx.wx.util.HttpUtil
import org.apache.commons.logging.LogFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception
import javax.annotation.Resource

@RestController
@RequestMapping("/user")
class User {
    private val log = LogFactory.getLog(User::class.java)

    @Resource
    private lateinit var us: UserImpl

    @RequestMapping("/info.get")
    fun getUserInfo(code: String?): Dto<String> {
        code?:return Dto(BaseEnum.LOST_PARAM)

        val usr = us.getUserInfo(code)
        return if(usr != null) {
            Dto(BaseEnum.GET_DATA_SUCCESS, usr)
        } else {
            Dto(BaseEnum.GET_DATA_FAIL)
        }
    }

    @RequestMapping(value = ["/info.update", "/info.insert"])
    fun updateUserInfo(name: String?, avatar: String?, openid: String?): Dto<Boolean> {
        name?:return Dto(BaseEnum.LOST_PARAM)
        avatar?:return Dto(BaseEnum.LOST_PARAM)
        openid?:return Dto(BaseEnum.LOST_PARAM)

        return if(us.updateUser(name, avatar, openid)) {
            Dto(BaseEnum.UPDATE_SUCCESS)
        } else {
            Dto(BaseEnum.UPDATE_FAIL)
        }
    }
}