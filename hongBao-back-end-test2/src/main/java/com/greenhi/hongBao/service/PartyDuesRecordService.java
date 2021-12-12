package com.greenhi.hongBao.service;

import com.greenhi.hongBao.entity.PartyDuesRecord;
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
public interface PartyDuesRecordService extends IService<PartyDuesRecord> {
    Result add(PartyDuesRecord partyDuesRecord);

    Result delete(Long id);

    Result getAllPaging(Integer pageNo, Integer pageSize);

    Result selectDuesRecordOneByID(Long id);

    Result selectDuesRecordByMemberID(String mid);

    Result selectDuesRecordByBranchName(String branchName);

    Result selectDuesRecordByBranchNameAndMonth(String branchName,String month);

}
