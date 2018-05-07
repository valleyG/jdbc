package com.mysit.spring.jdbc.dao;

import com.mysit.spring.jdbc.domain.User;

import java.util.List;

public interface UserDao {

    List<User> findUserListByDepartmentId(Integer id);
}
