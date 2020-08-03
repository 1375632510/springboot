package cn.analysys.demo.service.impl;

import cn.analysys.demo.entity.User;
import cn.analysys.demo.service.IUserService;
import cn.analysys.demo.userdao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.login(username,password);
    }
}
