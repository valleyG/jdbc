package com.mysit.spring.jdbc.service;

import com.mysit.spring.jdbc.domain.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    void addDepartment(Department department);

    void deleteDepartment(Department department);

    void modifyDepartment(Department department);

    Department findDepartmentById(Integer id);

    List<Department> findAllDepartmentList();

    List<Department> findDepartmentList(Map<String, Object> conditionMap);

}
