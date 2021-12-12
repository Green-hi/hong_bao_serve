package com.greenhi.hongBao.controller;

import com.greenhi.hongBao.entity.PartyBranch;
import com.greenhi.hongBao.entity.YouthLeagueBranch;
import com.greenhi.hongBao.service.YouthLeagueBranchService;
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
@RequestMapping("/youth-league-branch")
public class YouthLeagueBranchController {
    @Autowired
    private YouthLeagueBranchService service;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@RequestBody YouthLeagueBranch branch){
        return service.add(branch);
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
    public Result update(@RequestBody YouthLeagueBranch youthLeagueBranch){
        return service.update(youthLeagueBranch);
    }
}

