package com.greenhi.hongBao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.greenhi.hongBao.entity.AdminBase;
import com.greenhi.hongBao.mapper.AdminBaseMapper;
import com.greenhi.hongBao.service.AdminBaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greenhi.hongBao.unit.RandomUnit;
import com.greenhi.hongBao.unit.Result;
import com.greenhi.hongBao.unit.ResultEnum;
import com.greenhi.hongBao.unit.ResultUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author greenhi
 * @since 2021-11-15
 */
@Service
public class AdminBaseServiceImpl extends ServiceImpl<AdminBaseMapper, AdminBase> implements AdminBaseService {

    /**
     * 管理员注册接口
     *
     * @param aid
     * @param adminName
     * @param password
     * @return Result
     */
    @Override
    public Result logon(String aid, String adminName, String password) {
        if (aid.equals("") || adminName.equals("") || password.equals("")) {
            return ResultUtil.error(ResultEnum.DATA_IS_DEFECT.getCode(), ResultEnum.DATA_IS_DEFECT.getMsg());
        } else if (getOne(new QueryWrapper<AdminBase>()
                .eq("aid", aid)
        ) == null) {
            AdminBase adminBase = new AdminBase();
            adminBase.setAid(aid);
            adminBase.setAdminName(adminName);
            adminBase.setPassword(password);
            save(adminBase);
            return ResultUtil.success("管理员数据添加成功");
        } else {
            return ResultUtil.error(ResultEnum.USER_IS_EXISTS.getCode(), ResultEnum.USER_IS_EXISTS.getMsg());
        }
    }

    /**
     * 管理员登录接口
     *
     * @param aid
     * @param password
     * @param request  HttpServletRequest: 客户端请求封装对象
     * @return Result
     */
    @Override
    public Result login(String aid, String password, HttpServletRequest request) {

        if (aid.equals("") || password.equals("")) {
            return ResultUtil.error(ResultEnum.DATA_IS_DEFECT.getCode(), ResultEnum.DATA_IS_DEFECT.getMsg());
        } else {
            try {
                AdminBase adminBase = getOne(new QueryWrapper<AdminBase>()
                        .eq("aid", aid)
                );
                if (adminBase.getPassword().equals(password)) {
                    Map<String, Object> map = new HashMap<>();
                    List<String> sessionList = new ArrayList<>();
                    String loginToken = new RandomUnit().getLoginToken();
                    if (request.getSession().getAttribute("loginToken") != null) {
                        sessionList = (List<String>) request.getSession().getAttribute("loginToken");
                        while (true) {
                            if (sessionList.contains(loginToken)) {
                                loginToken = new RandomUnit().getLoginToken();
                            } else {
                                sessionList.add(loginToken);
                                request.getSession().setAttribute("loginToken", sessionList);
                                map.put("loginToken", loginToken);
                                map.put("adminInfo", adminBase);
                                break;
                            }
                        }
                    } else {
                        sessionList.add(loginToken);
                        request.getSession().setAttribute("loginToken", sessionList);
                        map.put("loginToken", loginToken);
                        map.put("adminInfo", adminBase);
                    }
                    return ResultUtil.success(map);
                } else {
                    return ResultUtil.error(ResultEnum.PASSWORD_ERROR.getCode(), ResultEnum.PASSWORD_ERROR.getMsg());
                }
            } catch (NullPointerException e) {
                return ResultUtil.error(ResultEnum.USER_NOT_EXISTS.getCode(), ResultEnum.USER_NOT_EXISTS.getMsg());
            }
        }
    }

    /**
     * 更新admin_base数据表的某条记录
     * @param adminBase
     * @return Result
     */
    @Override
    public Result update(AdminBase adminBase) {
        if (getOne(new QueryWrapper<AdminBase>()
                .eq("aid", adminBase.getAid())
        ) != null) {
            baseMapper.update(adminBase, new QueryWrapper<AdminBase>()
                    .eq("aid", adminBase.getAid()));
            return ResultUtil.success("管理员数据更新成功");
        }
        return ResultUtil.error(ResultEnum.USER_NOT_EXISTS.getCode(), ResultEnum.USER_NOT_EXISTS.getMsg());
    }
}
