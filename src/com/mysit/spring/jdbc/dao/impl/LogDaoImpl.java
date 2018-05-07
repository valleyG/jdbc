package com.mysit.spring.jdbc.dao.impl;

import com.mysit.spring.jdbc.dao.LogDao;
import com.mysit.spring.jdbc.domain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LogDaoImpl implements LogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void saveLog(Log log) {
        String sql="INSERT into spring_jdbc_log( log_content, log_create_time) VALUES (?,?)";
        Object [] params=new Object[]{
                log.getContent(),log.getCreateTime()
        };
        this.jdbcTemplate.update(sql,params);
    }
}
