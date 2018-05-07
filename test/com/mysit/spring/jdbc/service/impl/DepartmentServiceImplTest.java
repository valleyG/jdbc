package com.mysit.spring.jdbc.service.impl;

import com.mysit.spring.jdbc.domain.Department;
import com.mysit.spring.jdbc.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@ContextConfiguration("classpath*:/beans.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DepartmentServiceImplTest {
    @Autowired
    private DepartmentService departmentService;


    @Test
    public void testAddDepartment(){
        Department department = new Department();
        department.setName("FBI");
        department.setLocation("USA");
        this.departmentService.addDepartment(department);
    }
}