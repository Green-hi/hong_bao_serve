package com.greenhi.hongBao.controller;

import com.greenhi.hongBao.entity.GroupMessage;
import com.greenhi.hongBao.service.GroupMessageService;
import com.greenhi.hongBao.unit.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author greenhi
 * @since 2021-11-15
 */
@RestController
@RequestMapping("/group-message")
public class GroupMessageController {
    @Autowired
    private GroupMessageService service;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@RequestBody GroupMessage message){
        return service.add(message);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result delete(Long id){
        return service.delete(id);
    }

    @RequestMapping(value = "/getAllPaging",method = RequestMethod.GET)
    public Result getAllPaging(Integer pageNo, Integer pageSize){
        return service.getAllPaging(pageNo,pageSize) ;
    }

    @RequestMapping(value = "/selectOneByID",method = RequestMethod.GET)
    public Result selectOneByID(Long id){
        return service.selectGroupMessageOne(id) ;
    }
}

