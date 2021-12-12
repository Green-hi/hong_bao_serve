package com.greenhi.hongBao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greenhi.hongBao.entity.UserExtend;
import com.greenhi.hongBao.mapper.UserExtendMapper;
import com.greenhi.hongBao.service.UserExtendService;
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
public class UserExtendServiceImpl extends ServiceImpl<UserExtendMapper, UserExtend> implements UserExtendService {

    /**
     * 向user_extend数据表中添加一条记录
     * @param userExtend
     * @return Result
     */
    @Override
    public Result add(UserExtend userExtend) {
        if (getOne(new QueryWrapper<UserExtend>()
                .eq("uid", userExtend.getUid())
        ) == null) {
            save(userExtend);
            return ResultUtil.success("用户扩展数据添加成功");
        } else {
            return ResultUtil.error(ResultEnum.USER_IS_EXISTS.getCode(), ResultEnum.USER_IS_EXISTS.getMsg());
        }
    }

    /**
     * 删除user_extend中的某条记录
     * @param uid
     * @return Result
     */
    @Override
    public Result delete(String uid) {
        if (getOne(new QueryWrapper<UserExtend>()
                .eq("uid", uid)
        ) != null) {
            baseMapper.delete(new QueryWrapper<UserExtend>().eq("uid",uid));
            return ResultUtil.success("用户扩展数据已删除");
        } else {
            return ResultUtil.error(ResultEnum.USER_NOT_EXISTS.getCode(), ResultEnum.USER_NOT_EXISTS.getMsg());
        }
    }

    /**
     * 对user_extend分页查询
     * @param pageNo
     * @param pageSize
     * @return Result data: IPage<UserExtend>
     */
    @Override
    public Result getAllPaging(Integer pageNo, Integer pageSize) {
        IPage<UserExtend> mPage = new Page<>(pageNo, pageSize);
        QueryWrapper<UserExtend> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        IPage<UserExtend> userIPage = page(mPage, wrapper);
        if(userIPage != null){
            return ResultUtil.success(userIPage);
        }
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
    }

    /**
     * 查询一条user_extend数据
     * @param uid
     * @return Result data: UserExtend
     */
    @Override
    public Result selectUserOne(String uid) {
        UserExtend userExtend = getOne(new QueryWrapper<UserExtend>()
                .eq("uid", uid));
        if (userExtend == null) {
            return ResultUtil.error(ResultEnum.USER_NOT_EXISTS.getCode(), ResultEnum.USER_NOT_EXISTS.getMsg());
        } else {
            return ResultUtil.success(userExtend);
        }
    }

    /**
     * 更新user-extend数据表中的某条数据
     * @param userExtend
     * @return Result
     */
    @Override
    public Result update(UserExtend userExtend) {
        if (getOne(new QueryWrapper<UserExtend>()
                .eq("uid", userExtend.getUid())
        ) != null) {
            baseMapper.update(userExtend, new QueryWrapper<UserExtend>()
                    .eq("uid", userExtend.getUid()));
            return ResultUtil.success("用户扩展数据更新成功");
        }
        return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
    }
}
