package com.practice.sms.service.impl;

import com.practice.sms.bean.User;
import com.practice.sms.dao.UserMapper;
import com.practice.sms.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zyd on 2021/5/8 22:23
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int resetAllPassword() {
        return userMapper.resetAllPassword();
    }

    @Override
    public int resetPasswordByUserId(Integer id) {
        return userMapper.resetPasswordByUserId(id);
    }

    @Override
    public int resetVipByUserId(Integer id) {
        return userMapper.resetVipByUserId(id);
    }



    @Override
    public int deleteUserByUserId(Integer id) {
        return userMapper.deleteUserByUserId(id);
    }

    @Override
    public int updatePassword(Integer id, String password) {
        return userMapper.updatePassword(id, password);
    }

    @Override
    public List<User> getAllAdmin() {
        return userMapper.getAllAdmin();
    }

    @Override
    public User getUserByUserId(Integer id) {
        return userMapper.getUserByUserId(id);
    }

}
