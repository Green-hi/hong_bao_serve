package com.greenhi.hongBao.service;

import com.greenhi.hongBao.entity.Group;
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
public interface GroupService extends IService<Group> {

    Result add(Group group);

    Result delete(String gid);

    Result getAllPaging(Integer pageNo, Integer pageSize);

    Result selectGroupOne(String gid);

    Result update(Group group);

}
