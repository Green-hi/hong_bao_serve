package com.greenhi.hongBao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greenhi.hongBao.entity.UserBase;
import com.greenhi.hongBao.mapper.UserBaseMapper;
import com.greenhi.hongBao.service.UserBaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greenhi.hongBao.unit.Result;
import com.greenhi.hongBao.unit.ResultEnum;
import com.greenhi.hongBao.unit.ResultUtil;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author greenhi
 * @since 2021-11-15
 */
@Service
public class UserBaseServiceImpl extends ServiceImpl<UserBaseMapper, UserBase> implements UserBaseService {

    /**
     * 向user_base数据表中添加一条记录
     * @param userBase
     * @return Result
     */
    @Override
    public Result add(UserBase userBase) {

        if (getOne(new QueryWrapper<UserBase>()
                .eq("uid", userBase.getUid())
        ) == null) {
            save(userBase);
            return ResultUtil.success("用户基础数据添加成功");
        } else {
            return ResultUtil.error(ResultEnum.USER_IS_EXISTS.getCode(), ResultEnum.USER_IS_EXISTS.getMsg());
        }
    }

    /**
     * 删除user_base数据表中的某条记录
     * @param uid
     * @return Result
     */
    @Override
    public Result delete(String uid) {

        if (getOne(new QueryWrapper<UserBase>()
                .eq("uid", uid)
        ) != null) {
            baseMapper.delete(new QueryWrapper<UserBase>().eq("uid",uid));
            return ResultUtil.success("用户基础数据已经删除");
        } else {
            return ResultUtil.error(ResultEnum.USER_NOT_EXISTS.getCode(), ResultEnum.USER_NOT_EXISTS.getMsg());
        }
    }

    /**
     * 对user_base分页查询
     * @param pageNo
     * @param pageSize
     * @return Result data: IPage<UserBase>
     */
    @Override
    public Result getAllPaging(Integer pageNo, Integer pageSize) {
        IPage<UserBase> mPage = new Page<>(pageNo, pageSize);
        QueryWrapper<UserBase> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        IPage<UserBase> userIPage = page(mPage, wrapper);
        if(userIPage != null){
            return ResultUtil.success(userIPage);
        }
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
    }

    /**
     * 查询一条user_base数据
     * @param uid
     * @return Result data: UserBase
     */
    @Override
    public Result selectUserOne(String uid) {
        UserBase userBase = getOne(new QueryWrapper<UserBase>()
                .eq("uid", uid));
        if (userBase == null) {
            return ResultUtil.error(ResultEnum.USER_NOT_EXISTS.getCode(), ResultEnum.USER_NOT_EXISTS.getMsg());
        } else {
            return ResultUtil.success(userBase);
        }
    }

    /**
     * 更新user-base数据表中的某条数据
     * @param userBase
     * @return Result
     */
    @Override
    public Result update(UserBase userBase) {
        if (getOne(new QueryWrapper<UserBase>()
                .eq("uid", userBase.getUid())
        ) != null) {
            baseMapper.update(userBase, new QueryWrapper<UserBase>()
                    .eq("uid", userBase.getUid()));
            return ResultUtil.success("用户基础数据更新成功");
        }
        return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
    }
}
