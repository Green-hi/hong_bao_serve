package com.greenhi.hongBao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greenhi.hongBao.entity.YouthLeagueBranch;
import com.greenhi.hongBao.mapper.YouthLeagueBranchMapper;
import com.greenhi.hongBao.service.YouthLeagueBranchService;
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
public class YouthLeagueBranchServiceImpl extends ServiceImpl<YouthLeagueBranchMapper, YouthLeagueBranch> implements YouthLeagueBranchService {
    /**
     * 向youth_league_branch数据表中添加一条记录
     * @param youthLeagueBranch
     * @return Result
     */
    @Override
    public Result add(YouthLeagueBranch youthLeagueBranch) {
        if (getOne(new QueryWrapper<YouthLeagueBranch>()
                .eq("branch_name", youthLeagueBranch.getBranchName())
        ) == null) {
            save(youthLeagueBranch);
            return ResultUtil.success("团支部数据添加成功");
        } else {
            return ResultUtil.error(ResultEnum.DATA_IS_EXISTS.getCode(), ResultEnum.DATA_IS_EXISTS.getMsg());
        }
    }

    /**
     * 删除youth_league_branch数据表中的某条记录
     * @param branchName
     * @return Result
     */
    @Override
    public Result delete(String branchName) {
        if (getOne(new QueryWrapper<YouthLeagueBranch>()
                .eq("branch_name", branchName)
        ) != null) {
            baseMapper.delete(new QueryWrapper<YouthLeagueBranch>().eq("branch_name",branchName));
            return ResultUtil.success("团支部数据已经删除");
        } else {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        }
    }

    /**
     * 对youth_league_branch数据表分页查询
     * @param pageNo
     * @param pageSize
     * @return Result data: IPage<YouthLeagueBranch>
     */
    @Override
    public Result getAllPaging(Integer pageNo, Integer pageSize) {
        IPage<YouthLeagueBranch> mPage = new Page<>(pageNo, pageSize);
        QueryWrapper<YouthLeagueBranch> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        IPage<YouthLeagueBranch> branchIPage = page(mPage, wrapper);
        if(branchIPage != null){
            return ResultUtil.success(branchIPage);
        }
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
    }

    /**
     * 查询一条youth_league_branch数据表数据
     * @param branchName
     * @return Result data: YouthLeagueBranch
     */
    @Override
    public Result selectBranchOne(String branchName) {
        YouthLeagueBranch youthLeagueBranch = getOne(new QueryWrapper<YouthLeagueBranch>()
                .eq("branch_name", branchName));
        if (youthLeagueBranch == null) {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        } else {
            return ResultUtil.success(youthLeagueBranch);
        }
    }

    /**
     * 更新youth-league-branch数据表的某条记录
     * @param branch
     * @return Result
     */
    @Override
    public Result update(YouthLeagueBranch branch) {
        if (getOne(new QueryWrapper<YouthLeagueBranch>()
                .eq("id", branch.getId())
        ) != null) {
            baseMapper.update(branch, new QueryWrapper<YouthLeagueBranch>()
                    .eq("id", branch.getId()));
            return ResultUtil.success("团支部数据更新成功");
        }
        return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
    }
}
