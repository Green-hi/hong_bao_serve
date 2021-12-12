package com.greenhi.hongBao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greenhi.hongBao.entity.Group;
import com.greenhi.hongBao.mapper.GroupMapper;
import com.greenhi.hongBao.service.GroupService;
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
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements GroupService {

    /**
     * 向group数据表中添加一条记录
     *
     * @param group
     * @return Result
     */
    @Override
    public Result add(Group group) {
        if (getOne(new QueryWrapper<Group>()
                .eq("group_id", group.getGroupId())
        ) == null) {
            save(group);
            return ResultUtil.success("群组数据添加成功");
        } else {
            return ResultUtil.error(ResultEnum.DATA_IS_EXISTS.getCode(), ResultEnum.DATA_IS_EXISTS.getMsg());
        }
    }

    /**
     * 删除group数据表中的某条记录
     *
     * @param gid
     * @return Result
     */
    @Override
    public Result delete(String gid) {
        if (getOne(new QueryWrapper<Group>()
                .eq("group_id", gid)
        ) != null) {
            baseMapper.delete(new QueryWrapper<Group>().eq("group_id", gid));
            return ResultUtil.success("群组数据已经删除");
        } else {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        }
    }

    /**
     * 对group数据表分页查询
     *
     * @param pageNo
     * @param pageSize
     * @return Result data: IPage<Group>
     */
    @Override
    public Result getAllPaging(Integer pageNo, Integer pageSize) {
        IPage<Group> mPage = new Page<>(pageNo, pageSize);
        QueryWrapper<Group> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        IPage<Group> groupIPage = page(mPage, wrapper);
        if (groupIPage != null) {
            return ResultUtil.success(groupIPage);
        }
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
    }

    /**
     * 查询一条group数据表数据
     *
     * @param gid
     * @return Result data: Group
     */
    @Override
    public Result selectGroupOne(String gid) {
        Group group = getOne(new QueryWrapper<Group>()
                .eq("group_id", gid));
        if (group == null) {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        } else {
            return ResultUtil.success(group);
        }
    }

    /**
     * 更新user_group数据表的某条记录
     * @param group
     * @return Result
     */
    @Override
    public Result update(Group group) {
        if (getOne(new QueryWrapper<Group>()
                .eq("group_id", group.getGroupId())
        ) != null) {
            baseMapper.update(group, new QueryWrapper<Group>()
                    .eq("group_id", group.getGroupId()));
            return ResultUtil.success("群组数据更新成功");
        }
        return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
    }
}
