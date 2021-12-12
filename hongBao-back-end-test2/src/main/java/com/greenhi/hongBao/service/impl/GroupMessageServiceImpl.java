package com.greenhi.hongBao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.greenhi.hongBao.entity.GroupMessage;
import com.greenhi.hongBao.mapper.GroupMessageMapper;
import com.greenhi.hongBao.service.GroupMessageService;
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
public class GroupMessageServiceImpl extends ServiceImpl<GroupMessageMapper, GroupMessage> implements GroupMessageService {

    /**
     * 向group_message表中添加一条数据
     * @param message
     * @return Result
     */
    @Override
    public Result add(GroupMessage message) {
        if (save(message)) {
            return ResultUtil.success("群聊记录数据添加成功");
        }
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
    }

    /**
     * 删除group_message数据表中的某条记录
     * @param id
     * @return Result
     */
    @Override
    public Result delete(Long id) {
        if (getOne(new QueryWrapper<GroupMessage>()
                .eq("id", id)
        ) != null) {
            baseMapper.delete(new QueryWrapper<GroupMessage>().eq("id",id));
            return ResultUtil.success("群聊记录数据已经删除");
        } else {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        }
    }

    /**
     * 对group_message数据表分页查询
     * @param pageNo
     * @param pageSize
     * @return Result data: IPage<GroupMessage>
     */
    @Override
    public Result getAllPaging(Integer pageNo, Integer pageSize) {
        IPage<GroupMessage> mPage = new Page<>(pageNo, pageSize);
        QueryWrapper<GroupMessage> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        IPage<GroupMessage> messageIPage = page(mPage, wrapper);
        if(messageIPage != null){
            return ResultUtil.success(messageIPage);
        }
        return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
    }

    /**
     * 查询一条group_message数据表数据
     * @param id
     * @return Result data: GroupMessage
     */
    @Override
    public Result selectGroupMessageOne(Long id) {
        GroupMessage message = getOne(new QueryWrapper<GroupMessage>()
                .eq("id", id));
        if (message == null) {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        } else {
            return ResultUtil.success(message);
        }
    }
}
