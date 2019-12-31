package com.cx.wx.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/"])
class Index {
    @RequestMapping(value = ["/"])
    fun helloWorld() = "Hello World!"
}