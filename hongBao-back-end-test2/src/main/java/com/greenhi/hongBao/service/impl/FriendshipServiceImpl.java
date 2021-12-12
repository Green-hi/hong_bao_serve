package com.greenhi.hongBao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.greenhi.hongBao.entity.Friendship;
import com.greenhi.hongBao.mapper.FriendshipMapper;
import com.greenhi.hongBao.service.FriendshipService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greenhi.hongBao.unit.Result;
import com.greenhi.hongBao.unit.ResultEnum;
import com.greenhi.hongBao.unit.ResultUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author greenhi
 * @since 2021-11-15
 */
@Service
public class FriendshipServiceImpl extends ServiceImpl<FriendshipMapper, Friendship> implements FriendshipService {

    /**
     * 向friendship数据表中添加一条记录
     * @param friendship
     * @return Result
     */
    @Override
    public Result makeFriends(Friendship friendship) {
        if (getOne(new QueryWrapper<Friendship>()
                .eq("user_id", friendship.getUserId())
                .eq("friend_id",friendship.getFriendId())
        ) == null) {
            save(friendship);
            return ResultUtil.success("friend数据添加成功");
        } else {
            return ResultUtil.error(ResultEnum.DATA_IS_EXISTS.getCode(), ResultEnum.DATA_IS_EXISTS.getMsg());
        }
    }

    /**
     * 查询某个用户的所有friend
     * @param uid
     * @return Result data: List<Friendship>
     */
    @Override
    public Result showFriends(String uid) {
        List<Friendship> friendships = list(new QueryWrapper<Friendship>()
                .eq("user_id", uid));
        if (friendships.size()==0) {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        } else {
            return ResultUtil.success(friendships);
        }
    }

    /**
     * 删除friendship中的某条记录
     * @param uid
     * @param fid
     * @return Result
     */
    @Override
    public Result deleteFriend(String uid, String fid) {
        if (getOne(new QueryWrapper<Friendship>()
                .eq("user_id", uid)
        ) != null) {
            remove(new QueryWrapper<Friendship>()
                    .eq("user_id",uid)
                    .eq("friend_id",fid));
            return ResultUtil.success("friend数据已经删除");
        } else {
            return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
        }
    }

    /**
     * 更新friendship数据表的某条记录
     * @param friendship
     * @return Result
     */
    @Override
    public Result update(Friendship friendship) {
        if (getOne(new QueryWrapper<Friendship>()
                .eq("user_id", friendship.getUserId())
                .eq("friend_id",friendship.getFriendId())
        ) != null) {
            baseMapper.update(friendship, new QueryWrapper<Friendship>()
                    .eq("user_id", friendship.getUserId())
                    .eq("friend_id",friendship.getFriendId()));
            return ResultUtil.success("friendship数据更新成功");
        }
        return ResultUtil.error(ResultEnum.DATA_NOT_EXISTS.getCode(), ResultEnum.DATA_NOT_EXISTS.getMsg());
    }
}
