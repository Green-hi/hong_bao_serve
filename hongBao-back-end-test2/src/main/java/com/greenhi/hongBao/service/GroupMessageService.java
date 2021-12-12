package com.greenhi.hongBao.service;

import com.greenhi.hongBao.entity.GroupMessage;
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
public interface GroupMessageService extends IService<GroupMessage> {
    Result add(GroupMessage message);

    Result delete(Long id);

    Result getAllPaging(Integer pageNo, Integer pageSize);

    Result selectGroupMessageOne(Long id);
}
