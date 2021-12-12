package com.greenhi.hongBao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greenhi.hongBao.entity.PartyBranch;
import com.greenhi.hongBao.mapper.PartyBranchMapper;
import com.greenhi.hongBao.service.PartyBranchService;
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
public class PartyBranchServiceImpl extends ServiceImpl<PartyBranchMapper, PartyBranch> implements PartyBranchService {

    /**
     * 向party_branch数据表中添加一条记录
     * @param partyBranch
     * @return Result
     */
    @Override
    public Result add(PartyBranch partyBranch) {
        if (getOne(new QueryWrapper<PartyBranch>()
                .eq("branch_name", partyBranch.getBranchName())
        ) == null) {
            save(partyBranch);
            return ResultUtil.success("党支部数据添加成功");
        } else {
            return ResultUtil.error(ResultEnum.DATA_IS_EXISTS.getCode(), ResultEnum.DATA_IS_EXISTS.getMsg());
        }
    }

    /**
     * 删除party_branch数据表中的某条记录
     * @param branchName
     * @return Result
     */
    @Override
    public Result delete(String branchName) {
        if (getOne(new QueryWrapper<PartyBranch>()
                .eq("branch_name", branchName)
        ) != null) {
            baseMapper.delete(new QueryWrapper<PartyBranch>().eq("branch_name",branchName));
            return ResultUtil.success("党支部数据已经删除");
        } else {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        }
    }

    /**
     * 对party_branch数据表分页查询
     * @param pageNo
     * @param pageSize
     * @return Result data: IPage<PartyBranch>
     */
    @Override
    public Result getAllPaging(Integer pageNo, Integer pageSize) {
        IPage<PartyBranch> mPage = new Page<>(pageNo, pageSize);
        QueryWrapper<PartyBranch> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        IPage<PartyBranch> branchIPage = page(mPage, wrapper);
        if(branchIPage != null){
            return ResultUtil.success(branchIPage);
        }
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
    }

    /**
     * 查询一条party_branch数据表数据
     * @param branchName
     * @return Result data: PartyBranch
     */
    @Override
    public Result selectBranchOne(String branchName) {
        PartyBranch partyBranch = getOne(new QueryWrapper<PartyBranch>()
                .eq("branch_name", branchName));
        if (partyBranch == null) {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        } else {
            return ResultUtil.success(partyBranch);
        }
    }

    /**
     * 更新party_branch数据表的某条记录
     * @param partyBranch
     * @return Result
     */
    @Override
    public Result update(PartyBranch partyBranch) {
        if (getOne(new QueryWrapper<PartyBranch>()
                .eq("id", partyBranch.getId())
        ) != null) {
            baseMapper.update(partyBranch, new QueryWrapper<PartyBranch>()
                    .eq("id", partyBranch.getId()));
            return ResultUtil.success("党支部数据更新成功");
        }
        return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
    }
}
