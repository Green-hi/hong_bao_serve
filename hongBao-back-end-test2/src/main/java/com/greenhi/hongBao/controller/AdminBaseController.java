package com.greenhi.hongBao.controller;

import com.greenhi.hongBao.entity.AdminBase;
import com.greenhi.hongBao.service.AdminBaseService;
import com.greenhi.hongBao.unit.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author greenhi
 * @since 2021-11-15
 */
@RestController
@RequestMapping("/admin")
public class AdminBaseController {

    @Autowired
    private AdminBaseService adminBaseService;

    @RequestMapping(value = "/logon", method = RequestMethod.POST)
    public Result logon(String aid, String adminName, String password) {
        return adminBaseService.logon(aid, adminName, password);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(String aid, String password, HttpServletRequest request) {
        return adminBaseService.login(aid, password, request);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(@RequestBody AdminBase adminBase) {
        return adminBaseService.update(adminBase);
    }

}

