package com.greenhi.hongBao.controller;

import com.greenhi.hongBao.entity.Group;
import com.greenhi.hongBao.service.GroupService;
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
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService service;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@RequestBody Group group){
        return service.add(group);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result delete(String gid){
        return service.delete(gid);
    }

    @RequestMapping(value = "/getAllPaging",method = RequestMethod.GET)
    public Result getAllPaging(Integer pageNo, Integer pageSize){
        return service.getAllPaging(pageNo,pageSize) ;
    }

    @RequestMapping(value = "/selectOneByGid",method = RequestMethod.GET)
    public Result selectOneByGid(String gid){
        return service.selectGroupOne(gid) ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result update(@RequestBody Group group){
        return service.update(group);
    }

}

