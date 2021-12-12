package com.greenhi.hongBao.mapper;

import com.greenhi.hongBao.entity.PartyDuesRecord;
import com.greenhi.hongBao.entity.YouthDuesRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author greenhi
 * @since 2021-11-15
 */
public interface YouthDuesRecordMapper extends BaseMapper<YouthDuesRecord> {
    List<YouthDuesRecord> getListByBranchName(String branchName);

    List<YouthDuesRecord> getListByBranchNameAndMonth(String branchName, String month);
}
