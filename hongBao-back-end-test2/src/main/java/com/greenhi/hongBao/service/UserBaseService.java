package com.greenhi.hongBao.service;

import com.greenhi.hongBao.entity.UserBase;
import com.baomidou.mybatisplus.extension.service.IService;
import com.greenhi.hongBao.unit.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author greenhi
 * @since 2021-11-15
 */
public interface UserBaseService extends IService<UserBase> {

    Result add(UserBase userBase);

    Result delete(String uid);

    Result getAllPaging(Integer pageNo, Integer pageSize);

    Result selectUserOne(String uid);

    Result update(UserBase userBase);

}
