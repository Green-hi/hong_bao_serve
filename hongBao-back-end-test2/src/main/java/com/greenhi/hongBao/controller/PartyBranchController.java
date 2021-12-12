package com.greenhi.hongBao.controller;

import com.greenhi.hongBao.entity.PartyBranch;
import com.greenhi.hongBao.service.PartyBranchService;
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
@RequestMapping("/party-branch")
public class PartyBranchController {
    @Autowired
    private PartyBranchService service;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@RequestBody PartyBranch partyBranch){
        return service.add(partyBranch);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result delete(String branchName){
        return service.delete(branchName);
    }

    @RequestMapping(value = "/getAllPaging",method = RequestMethod.GET)
    public Result getAllPaging(Integer pageNo, Integer pageSize){
        return service.getAllPaging(pageNo,pageSize) ;
    }

    @RequestMapping(value = "/selectOneByName",method = RequestMethod.GET)
    public Result selectOneByName(String branchName){
        return service.selectBranchOne(branchName) ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Result update(@RequestBody PartyBranch partyBranch){
        return service.update(partyBranch);
    }

}

