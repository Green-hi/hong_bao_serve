package com.greenhi.hongBao.controller;

import com.greenhi.hongBao.entity.UserExtend;
import com.greenhi.hongBao.service.UserExtendService;
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
@RequestMapping("/user-extend")
public class UserExtendController {

    @Autowired
    private UserExtendService service;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@RequestBody UserExtend user){
        return service.add(user);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result delete(String uid){
        return service.delete(uid);
    }

    @RequestMapping(value = "/getAllPaging",method = RequestMethod.GET)
    public Result getAllPaging(Integer pageNo, Integer pageSize){
        return service.getAllPaging(pageNo,pageSize) ;
    }

    @RequestMapping(value = "/selectOneByUid",method = RequestMethod.GET)
    public Result selectOneByUid(String uid){
        return service.selectUserOne(uid) ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result update(@RequestBody UserExtend userExtend){
        return service.update(userExtend);
    }

}

