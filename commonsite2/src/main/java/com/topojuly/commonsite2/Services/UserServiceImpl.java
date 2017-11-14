package com.topojuly.commonsite2.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topojuly.commonsite2.Domains.User;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int add(User user) {
        return this.userDao.add(user);
    }

    @Override
    public int update(User user) {
        return this.userDao.update(user);
    }

    @Override
    public int delete(Long id) {
        return this.userDao.delete(id);
    }

    @Override
    public User findUser(Long id) {
        return this.userDao.findUser(id);
    }

    @Override
    public List<User> findUserList() {
        return this.userDao.findUserList();
    }
}