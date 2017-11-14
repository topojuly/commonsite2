package com.topojuly.commonsite2.Services;

import java.util.List;

import com.topojuly.commonsite2.Domains.User;

public interface UserDao {
    int add(User user);
    int update(User user);
    int delete(Long id);
    User findUser(Long id);
    List<User> findUserList();
}