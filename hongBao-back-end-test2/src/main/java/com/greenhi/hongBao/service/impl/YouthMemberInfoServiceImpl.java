package com.greenhi.hongBao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greenhi.hongBao.entity.YouthMemberInfo;
import com.greenhi.hongBao.mapper.YouthMemberInfoMapper;
import com.greenhi.hongBao.service.YouthMemberInfoService;
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
public class YouthMemberInfoServiceImpl extends ServiceImpl<YouthMemberInfoMapper, YouthMemberInfo> implements YouthMemberInfoService {
    /**
     * 向youth_member_info数据表中添加一条记录
     * @param YouthMemberInfo
     * @return Result
     */
    @Override
    public Result add(YouthMemberInfo YouthMemberInfo) {
        if (getOne(new QueryWrapper<YouthMemberInfo>()
                .eq("mid", YouthMemberInfo.getMid())
        ) == null) {
            save(YouthMemberInfo);
            return ResultUtil.success("团员数据添加成功");
        } else {
            return ResultUtil.error(ResultEnum.DATA_IS_EXISTS.getCode(), ResultEnum.DATA_IS_EXISTS.getMsg());
        }
    }

    /**
     * 删除youth_member_info数据表中的某条记录
     * @param mid
     * @return Result
     */
    @Override
    public Result deleteByMemberID(String mid) {
        if (getOne(new QueryWrapper<YouthMemberInfo>()
                .eq("mid", mid)
        ) != null) {
            baseMapper.delete(new QueryWrapper<YouthMemberInfo>().eq("mid",mid));
            return ResultUtil.success("团员数据已经删除");
        } else {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        }
    }

    /**
     * 对youth_member_info数据表分页查询
     * @param pageNo
     * @param pageSize
     * @return Result data: IPage<YouthMemberInfo>
     */
    @Override
    public Result getAllPaging(Integer pageNo, Integer pageSize) {
        IPage<YouthMemberInfo> mPage = new Page<>(pageNo, pageSize);
        QueryWrapper<YouthMemberInfo> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        IPage<YouthMemberInfo> memberInfoIPage = page(mPage, wrapper);
        if(memberInfoIPage != null){
            return ResultUtil.success(memberInfoIPage);
        }
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
    }

    /**
     * 查询一条youth_member_info数据表数据
     * @param mid
     * @return Result data: YouthMemberInfo
     */
    @Override
    public Result selectOneByMemberID(String mid) {
        YouthMemberInfo memberInfo = getOne(new QueryWrapper<YouthMemberInfo>()
                .eq("mid", mid));
        if (memberInfo == null) {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        } else {
            return ResultUtil.success(memberInfo);
        }
    }

    /**
     * 更新youth_member_info数据表中的某条数据
     * @param youthMemberInfo
     * @return Result
     */
    @Override
    public Result update(YouthMemberInfo youthMemberInfo) {
        if (getOne(new QueryWrapper<YouthMemberInfo>()
                .eq("mid", youthMemberInfo.getMid())
        ) != null) {
            baseMapper.update(youthMemberInfo, new QueryWrapper<YouthMemberInfo>()
                    .eq("mid", youthMemberInfo.getMid()));
            return ResultUtil.success("团员数据更新成功");
        }
        return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
    }
}
