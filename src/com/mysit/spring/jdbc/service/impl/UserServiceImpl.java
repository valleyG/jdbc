package com.mysit.spring.jdbc.service.impl;

import com.mysit.spring.jdbc.dao.UserDao;
import com.mysit.spring.jdbc.domain.User;
import com.mysit.spring.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public void addUser(User user) {
    }

    @Override
    public void deleteUser(User user) {
    }

    @Override
    public User findUserById(Integer id) {
        return null;
    }

    @Override
    public List<User> findUserListByDepartmentId(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("");
        }

        return this.userDao.findUserListByDepartmentId(id);
    }
}
