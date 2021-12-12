package com.greenhi.hongBao.service;

import com.greenhi.hongBao.entity.YouthMemberInfo;
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
public interface YouthMemberInfoService extends IService<YouthMemberInfo> {
    Result add(YouthMemberInfo youthMemberInfo);

    Result deleteByMemberID(String mid);

    Result getAllPaging(Integer pageNo, Integer pageSize);

    Result selectOneByMemberID(String mid);

    Result update(YouthMemberInfo youthMemberInfo);
}
