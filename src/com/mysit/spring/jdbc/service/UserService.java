package com.mysit.spring.jdbc.service;

import com.mysit.spring.jdbc.domain.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void deleteUser(User user);

    User findUserById(Integer id);

    List<User> findUserListByDepartmentId(Integer id);
}
