package com.greenhi.hongBao.service;

import com.greenhi.hongBao.entity.Friendship;
import com.baomidou.mybatisplus.extension.service.IService;
import com.greenhi.hongBao.unit.Result;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author greenhi
 * @since 2021-11-15
 */
public interface FriendshipService extends IService<Friendship> {

    Result makeFriends(Friendship friendship);

    Result showFriends(String uid);

    Result deleteFriend(String uid, String fid);

    Result update(Friendship friendship);
}
