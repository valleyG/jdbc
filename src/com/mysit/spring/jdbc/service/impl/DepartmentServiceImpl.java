package com.mysit.spring.jdbc.service.impl;

import com.mysit.spring.jdbc.dao.DepartmentDao;
import com.mysit.spring.jdbc.domain.Department;
import com.mysit.spring.jdbc.domain.Log;
import com.mysit.spring.jdbc.domain.User;
import com.mysit.spring.jdbc.service.DepartmentService;
import com.mysit.spring.jdbc.service.LogService;
import com.mysit.spring.jdbc.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Service("departmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private UserService userService;
    @Autowired
    private LogService logService;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("");
        }

        this.departmentDao.save(department);
        Log log = new Log();
        log.setContent("测试日志");
        log.setCreateTime(new Date());
        this.logService.addLog(log);
    }

    @Override
    public void deleteDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("");
        }

        // TODO 查询该部门下有没有员工，如果有不能删除
        List<User> userList = this.userService.findUserListByDepartmentId(department.getId());
        if (CollectionUtils.isNotEmpty(userList)) {
            throw new RuntimeException("部门有员工，不能删除");
        }

        this.departmentDao.delete(department);
    }

    @Override
    public void modifyDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("");
        }

        this.departmentDao.update(department);
    }

    @Override
    public Department findDepartmentById(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("");
        }
        return this.departmentDao.findById(id);
    }

    @Override
    public List<Department> findAllDepartmentList() {
        return this.departmentDao.findAll();
    }

    @Override
    public List<Department> findDepartmentList(Map<String, Object> conditionMap) {
        return this.departmentDao.findDepartmentList(conditionMap);
    }

}
