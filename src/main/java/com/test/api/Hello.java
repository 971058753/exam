package com.test.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class Hello {
    @RequestMapping("hello")
    public String hello() {
        return "hello 闲鱼用户 抢粮哦呀的大叔";
    }
}    