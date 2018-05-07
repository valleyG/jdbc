package com.mysit.spring.jdbc.dao.impl;

import com.mysit.spring.jdbc.dao.DepartmentDao;
import com.mysit.spring.jdbc.dao.UserDao;
import com.mysit.spring.jdbc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DepartmentDao departmentDao;


    @Override
    public List<User> findUserListByDepartmentId(Integer id) {
        String sql = "SELECT\n" +
                "    user_id,\n" +
                "    user_name,\n" +
                "    user_password,\n" +
                "    user_salary,\n" +
                "    user_birthday,\n" +
                "    department_id\n" +
                "FROM spring_jdbc_user\n" +
                "WHERE department_id = ?";
        Object[] params = new Object[]{id};
        return this.jdbcTemplate.query(sql, params, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setSalary(resultSet.getFloat(4));
                user.setBirthday(resultSet.getDate(5));
                user.setDepartment(departmentDao.findById(resultSet.getInt(6)));
                return user;

            }
        });
    }
}
