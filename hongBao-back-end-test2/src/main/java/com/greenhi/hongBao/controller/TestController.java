package com.greenhi.hongBao.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "<h1 align=\"center\"style=\"color:red;font-size:50px\"><i>Hello! HongBao</i></h1>";
    }
}
