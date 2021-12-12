package com.greenhi.hongBao.service;

import com.greenhi.hongBao.entity.YouthDuesRecord;
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
public interface YouthDuesRecordService extends IService<YouthDuesRecord> {
    Result add(YouthDuesRecord youthDuesRecord);

    Result delete(Long id);

    Result getAllPaging(Integer pageNo, Integer pageSize);

    Result selectDuesRecordOneByID(Long id);

    Result selectDuesRecordByMemberID(String mid);

    Result selectDuesRecordByBranchName(String branchName);

    Result selectDuesRecordByBranchNameAndMonth(String branchName,String month);
}
