package com.cx.wx

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan("com.cx.wx.dao")
class WxApplication

fun main(args: Array<String>) {
    runApplication<WxApplication>(*args)
}
