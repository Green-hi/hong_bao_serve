package com.greenhi.hongBao.controller;

import com.greenhi.hongBao.entity.AdminBase;
import com.greenhi.hongBao.entity.Friendship;
import com.greenhi.hongBao.service.FriendshipService;
import com.greenhi.hongBao.unit.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author greenhi
 * @since 2021-11-15
 */
@RestController
@RequestMapping("/friendship")
public class FriendshipController {

    @Autowired
    private FriendshipService service;

    @RequestMapping(value = "/makeFriends", method = RequestMethod.POST)
    public Result add(@RequestBody Friendship friendship) {
        return service.makeFriends(friendship);
    }

    @RequestMapping(value = "/showFriends", method = RequestMethod.GET)
    public Result select(String uid) {
        return service.showFriends(uid);
    }

    @RequestMapping(value = "/deleteFriend", method = RequestMethod.POST)
    public Result delete(String uid, String fid) {
        return service.deleteFriend(uid, fid);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(@RequestBody Friendship friendship) {
        return service.update(friendship);
    }
}

