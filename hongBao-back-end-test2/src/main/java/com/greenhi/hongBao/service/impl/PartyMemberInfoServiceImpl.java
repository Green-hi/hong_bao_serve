package com.greenhi.hongBao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greenhi.hongBao.entity.PartyMemberInfo;
import com.greenhi.hongBao.mapper.PartyMemberInfoMapper;
import com.greenhi.hongBao.service.PartyMemberInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greenhi.hongBao.unit.Result;
import com.greenhi.hongBao.unit.ResultEnum;
import com.greenhi.hongBao.unit.ResultUtil;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author greenhi
 * @since 2021-11-15
 */
@Service
public class PartyMemberInfoServiceImpl extends ServiceImpl<PartyMemberInfoMapper, PartyMemberInfo> implements PartyMemberInfoService {

    /**
     * 向party_member_info数据表中添加一条记录
     * @param partyMemberInfo
     * @return Result
     */
    @Override
    public Result add(PartyMemberInfo partyMemberInfo) {
        if (getOne(new QueryWrapper<PartyMemberInfo>()
                .eq("mid", partyMemberInfo.getMid())
        ) == null) {
            save(partyMemberInfo);
            return ResultUtil.success("党员数据添加成功");
        } else {
            return ResultUtil.error(ResultEnum.DATA_IS_EXISTS.getCode(), ResultEnum.DATA_IS_EXISTS.getMsg());
        }
    }

    /**
     * 删除party_member_info数据表中的某条记录
     * @param mid
     * @return Result
     */
    @Override
    public Result deleteByMemberID(String mid) {
        if (getOne(new QueryWrapper<PartyMemberInfo>()
                .eq("mid", mid)
        ) != null) {
            baseMapper.delete(new QueryWrapper<PartyMemberInfo>().eq("mid",mid));
            return ResultUtil.success("党员数据已经删除");
        } else {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        }
    }

    /**
     * 对party_member_info数据表分页查询
     * @param pageNo
     * @param pageSize
     * @return Result data: IPage<PartyMemberInfo>
     */
    @Override
    public Result getAllPaging(Integer pageNo, Integer pageSize) {
        IPage<PartyMemberInfo> mPage = new Page<>(pageNo, pageSize);
        QueryWrapper<PartyMemberInfo> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        IPage<PartyMemberInfo> memberInfoIPage = page(mPage, wrapper);
        if(memberInfoIPage != null){
            return ResultUtil.success(memberInfoIPage);
        }
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
    }

    /**
     * 查询一条party_member_info数据表数据
     * @param mid
     * @return Result data: PartyMemberInfo
     */
    @Override
    public Result selectOneByMemberID(String mid) {
        PartyMemberInfo memberInfo = getOne(new QueryWrapper<PartyMemberInfo>()
                .eq("mid", mid));
        if (memberInfo == null) {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        } else {
            return ResultUtil.success(memberInfo);
        }
    }

    /**
     * 更新party_member_info数据表中的某条数据
     * @param partyMemberInfo
     * @return Result
     */
    @Override
    public Result update(PartyMemberInfo partyMemberInfo) {
        if (getOne(new QueryWrapper<PartyMemberInfo>()
                .eq("mid", partyMemberInfo.getMid())
        ) != null) {
            baseMapper.update(partyMemberInfo, new QueryWrapper<PartyMemberInfo>()
                    .eq("mid", partyMemberInfo.getMid()));
            return ResultUtil.success("党员数据更新成功");
        }
        return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
    }
}
