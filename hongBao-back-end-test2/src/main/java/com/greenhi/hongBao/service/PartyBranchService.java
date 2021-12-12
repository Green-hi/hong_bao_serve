package com.greenhi.hongBao.service;

import com.greenhi.hongBao.entity.PartyBranch;
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
public interface PartyBranchService extends IService<PartyBranch> {

    Result add(PartyBranch partyBranch);

    Result delete(String branchName);

    Result getAllPaging(Integer pageNo, Integer pageSize);

    Result selectBranchOne(String branchName);

    Result update(PartyBranch partyBranch);

}
