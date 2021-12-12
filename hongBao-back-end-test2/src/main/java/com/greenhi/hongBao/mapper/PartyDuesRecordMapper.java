package com.greenhi.hongBao.mapper;

import com.greenhi.hongBao.entity.PartyDuesRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author greenhi
 * @since 2021-11-15
 */
public interface PartyDuesRecordMapper extends BaseMapper<PartyDuesRecord> {

    List<PartyDuesRecord> getListByBranchName(String branchName);

    List<PartyDuesRecord> getListByBranchNameAndMonth(String branchName, String month);

}
