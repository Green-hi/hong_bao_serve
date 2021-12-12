package com.greenhi.hongBao.mapper;

import com.greenhi.hongBao.entity.PartyMemberInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author greenhi
 * @since 2021-11-15
 */
public interface PartyMemberInfoMapper extends BaseMapper<PartyMemberInfo> {

    String queryBranchNameByMid(String mid);

}
