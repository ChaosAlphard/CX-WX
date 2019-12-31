package com.cx.wx.controller

import com.cx.wx.dto.Dto
import com.cx.wx.dto.enums.BaseEnum
import com.cx.wx.model.wxsend.RemindMsg
import com.cx.wx.model.wxsend.Val
import com.cx.wx.service.WXApiService
import com.cx.wx.service.impl.WXApiImpl
import com.cx.wx.util.DateUtil
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/wx")
class WXApi {
    val log: Log = LogFactory.getLog(WXApi::class.java)

    val wx: WXApiService = WXApiImpl()

    @RequestMapping("submsg.sendToManager")
    fun sendToManager(msg: String?, from: String?): Dto<Any> {
        msg?:return Dto(BaseEnum.LOST_PARAM)
        from?:return Dto(BaseEnum.LOST_PARAM)

        val managerOpenid = "oqFTn5Yr2QNr_-492HBzh7I_w53Y"
        val templateid = "8yJvg3O8n7FReHC8KUDChlFMoxNIDqEAvzGr2o_Vx5o"
        val page = "pages/manage/manage?openid=$managerOpenid&msg=$msg"
        val message = RemindMsg()
                .setThing1(Val(msg))
                .setDate2(Val(DateUtil.getCurrentDate()))

        return try {
            Dto(BaseEnum.SEND_MESSAGE_SUCCESS,
                wx.getSubscribeMessage(
                    managerOpenid,
                    templateid,
                    page,
                    message,
                    RemindMsg::class.java
            ))
        } catch (e: Exception) {
            log.error("发送失败",e)
            Dto(BaseEnum.SEND_MESSAGE_FAIL)
        }
    }

    @RequestMapping("/submsg.sendToRepairer")
    fun pugSubMsg(openid: String?, agree: String?, msg: String?): Dto<RemindMsg> {
        openid?:return Dto(BaseEnum.LOST_PARAM)
        agree?:return Dto(BaseEnum.LOST_PARAM)
        val templateid = "8yJvg3O8n7FReHC8KUDChlFMoxNIDqEAvzGr2o_Vx5o"
        val msg2 = if("true" == agree){
            "${msg}同意${DateUtil.getCurrentSecond()}"
        } else {
            "${msg}不同意"
        }
        val message = RemindMsg()
                .setThing1(Val(msg2))
                .setDate2(Val(DateUtil.getCurrentDate()))

        return try {
            Dto(BaseEnum.SEND_MESSAGE_SUCCESS,
                wx.getSubscribeMessage(
                    openid,
                    templateid,
                    message,
                    RemindMsg::class.java
            ))
        } catch (e: Exception) {
            log.error("发送失败",e)
            Dto(BaseEnum.SEND_MESSAGE_FAIL)
        }
    }
}