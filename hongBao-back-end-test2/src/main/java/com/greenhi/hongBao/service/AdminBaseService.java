package com.greenhi.hongBao.service;

import com.greenhi.hongBao.entity.AdminBase;
import com.baomidou.mybatisplus.extension.service.IService;
import com.greenhi.hongBao.unit.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author greenhi
 * @since 2021-11-15
 */
public interface AdminBaseService extends IService<AdminBase> {

    Result logon(String aid,String adminName,String password) ;

    Result login(String aid, String password, HttpServletRequest request) ;

    Result update(AdminBase adminBase);

}
