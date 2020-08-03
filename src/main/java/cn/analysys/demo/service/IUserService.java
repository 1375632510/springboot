package cn.analysys.demo.service;

import cn.analysys.demo.entity.User;

public interface IUserService {
    User login(String username,String password);
}
