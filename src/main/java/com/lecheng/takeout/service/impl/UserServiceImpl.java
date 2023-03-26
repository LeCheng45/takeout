package com.lecheng.takeout.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lecheng.takeout.common.R;
import com.lecheng.takeout.entity.User;
import com.lecheng.takeout.mapper.UserMapper;
import com.lecheng.takeout.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户登录
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public R login(String phone) {
        LambdaQueryWrapper<User> wapper = new LambdaQueryWrapper<>();
        wapper.eq(User::getPhone,phone);
        User user = userMapper.selectOne(wapper);
        if (user == null){
            user = new User();
            user.setPhone(phone);
            user.setStatus(1);
            userMapper.insert(user);
        }
        if (user.getStatus()==0){
            return R.error("用户被禁用");
        }
        return R.success(user);
    }
}
