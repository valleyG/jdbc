package com.mysit.spring.jdbc.dao.impl;

import com.mysit.spring.jdbc.dao.DepartmentDao;
import com.mysit.spring.jdbc.domain.Department;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
@Repository
public class DepartmentDaoImpl implements DepartmentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Override
    public void save(Department department) {
        String sql = "INSERT INTO spring_jdbc_department (department_name, department_location) VALUES (?,?)";
        Object[] params = new Object[]{department.getName(), department.getLocation()};
        this.jdbcTemplate.update(sql, params);
    }

    @Override
    public void delete(Department department) {
        String sql = "DELETE FROM spring_jdbc_department WHERE department_id = ?";
        Object[] params = new Object[]{department.getId()};
        this.jdbcTemplate.update(sql, params);
    }

    @Override
    public void update(Department department) {
        String sql = "UPDATE spring_jdbc_department\n" +
                "SET\n" +
                "    department_name     = ?,\n" +
                "    department_location = ?\n" +
                "WHERE department_id = ?";
        Object[] params = new Object[]{department.getName(), department.getLocation(), department.getId()};
        this.jdbcTemplate.update(sql, params);
    }

    @Override
    public Department findById(Integer id) {
        String sql = "SELECT\n" +
                "    department_id,\n" +
                "    department_name,\n" +
                "    department_location\n" +
                "FROM spring_jdbc_department\n" +
                "WHERE department_id = ?";
        Object[] params = new Object[]{id};
        return this.jdbcTemplate.queryForObject(sql, params, new RowMapper<Department>() {
            @Override
            public Department mapRow(ResultSet resultSet, int i) throws SQLException {
                return departmentRowMap(resultSet);
            }
        });
    }

    @Override
    public List<Department> findAll() {
        String sql = "SELECT" +
                "  department_id," +
                "  deparmtent_name," +
                "  department_location" +
                "  FROM spring_jdbc_department";
        return this.jdbcTemplate.query(sql, new RowMapper<Department>() {
            @Override
            public Department mapRow(ResultSet resultSet, int i) throws SQLException {
                return departmentRowMap(resultSet);
            }
        });
    }

    @Override
    public List<Department> findDepartmentList(Map<String, Object> conditionMap) {
        List<Object> paramList = new ArrayList<>();
        Object[] params = new Object[conditionMap.values().size()];

        if (MapUtils.isEmpty(conditionMap)) {
            return this.findAll();
        }

        StringBuilder sql = new StringBuilder(" SELECT * FROM spring_jdbc_department WHERE 1 = 1 ");
        for (Iterator<Map.Entry<String,Object>> iterator = conditionMap.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<String,Object> entry =  iterator.next();
            String fieldName = entry.getKey();
            Object fieldValue = entry.getValue();
            paramList.add(fieldValue);

            sql.append(" AND ").append(fieldName).append("= ?");
        }

        params = paramList.toArray();


        return this.jdbcTemplate.query(sql.toString(), params, new RowMapper<Department>() {
            @Override
            public Department mapRow(ResultSet resultSet, int i) throws SQLException {
                return departmentRowMap(resultSet);
            }
        });
    }


    private Department departmentRowMap(ResultSet resultSet) throws SQLException {
        Department department = new Department();
        department.setId(resultSet.getInt(1));
        department.setName(resultSet.getString(2));
        department.setLocation(resultSet.getString(3));
        return department;
    }
}
