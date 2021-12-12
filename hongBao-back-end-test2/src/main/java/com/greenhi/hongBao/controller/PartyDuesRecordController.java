package com.greenhi.hongBao.controller;

import com.greenhi.hongBao.entity.PartyDuesRecord;
import com.greenhi.hongBao.service.PartyDuesRecordService;
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
@RequestMapping("/party-dues-record")
public class PartyDuesRecordController {
    @Autowired
    private PartyDuesRecordService service;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@RequestBody PartyDuesRecord record){
        return service.add(record);
    }

    @RequestMapping(value = "/deleteByID",method = RequestMethod.POST)
    public Result delete(Long id){
        return service.delete(id);
    }

    @RequestMapping(value = "/getAllPaging",method = RequestMethod.GET)
    public Result getAllPaging(Integer pageNo, Integer pageSize){
        return service.getAllPaging(pageNo,pageSize) ;
    }

    @RequestMapping(value = "/selectOneByID",method = RequestMethod.GET)
    public Result selectOneByID(Long id){
        return service.selectDuesRecordOneByID(id) ;
    }

    @RequestMapping(value = "/selectByMemberID",method = RequestMethod.GET)
    public Result selectByMemberID(String mid){
        return service.selectDuesRecordByMemberID(mid) ;
    }

    @RequestMapping(value = "/selectByBranchName",method = RequestMethod.GET)
    public Result selectByBranchName(String branchName){
        return service.selectDuesRecordByBranchName(branchName);
    }

    @RequestMapping(value = "/selectByBranchNameAndMonth",method = RequestMethod.GET)
    public Result selectByBranchNameAndMonth(String branchName,String month){
        return service.selectDuesRecordByBranchNameAndMonth(branchName,month);
    }
}

