package com.cx.wx.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/manage")
class Manage {

    @RequestMapping("/decision.make")
    fun decision(flag: String?): String {
        return ""
    }
}