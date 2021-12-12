package com.greenhi.hongBao.controller;

import com.greenhi.hongBao.entity.PartyMemberInfo;
import com.greenhi.hongBao.service.PartyMemberInfoService;
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
@RequestMapping("/party-member-info")
public class PartyMemberInfoController {
    @Autowired
    private PartyMemberInfoService service;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@RequestBody PartyMemberInfo memberInfo){
        return service.add(memberInfo);
    }

    @RequestMapping(value = "/deleteByMemberID",method = RequestMethod.POST)
    public Result delete(String mid){
        return service.deleteByMemberID(mid);
    }

    @RequestMapping(value = "/getAllPaging",method = RequestMethod.GET)
    public Result getAllPaging(Integer pageNo, Integer pageSize){
        return service.getAllPaging(pageNo,pageSize) ;
    }

    @RequestMapping(value = "/selectOneByMemberID",method = RequestMethod.GET)
    public Result selectOneByMemberID(String mid){
        return service.selectOneByMemberID(mid) ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result update(@RequestBody PartyMemberInfo partyMemberInfo){
        return service.update(partyMemberInfo);
    }
}

