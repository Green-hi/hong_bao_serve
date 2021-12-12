package com.greenhi.hongBao.service;

import com.greenhi.hongBao.entity.YouthLeagueBranch;
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
public interface YouthLeagueBranchService extends IService<YouthLeagueBranch> {
    Result add(YouthLeagueBranch partyBranch);

    Result delete(String branchName);

    Result getAllPaging(Integer pageNo, Integer pageSize);

    Result selectBranchOne(String branchName);

    Result update(YouthLeagueBranch branch);
}
