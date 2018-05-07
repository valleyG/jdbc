package com.mysit.spring.jdbc.service.impl;

import com.mysit.spring.jdbc.dao.LogDao;
import com.mysit.spring.jdbc.domain.Log;
import com.mysit.spring.jdbc.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("logService")
@Transactional
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    @Override
    public void addLog(Log log) {
        this.logDao.saveLog(log);
    }
}
