package com.mysit.spring.jdbc.dao;

import com.mysit.spring.jdbc.domain.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentDao {

    void save(Department department);

    void delete(Department department);

    void update(Department department);

    Department findById(Integer id);

    List<Department> findAll();

    List<Department> findDepartmentList(Map<String, Object> conditionMap);



}
