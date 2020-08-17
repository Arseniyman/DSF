package com.av.springmvc.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.av.springmvc.Models.Employee;
import com.av.springmvc.Models.EmployeeMapper;

@Repository
public class JdbcEmployeeDao extends JdbcDaoSupport implements Dao<Employee> {
	
	@Autowired
	public JdbcEmployeeDao(JdbcTemplate jdbcTemplate) {
		super.setJdbcTemplate(jdbcTemplate);
	}

	@Override
	public List<Employee> getAll() {
		
		String sql = "SELECT * FROM employee";
		return super.getJdbcTemplate().query(sql, new EmployeeMapper());
	}
	
	@Override
	public Employee getById(int id) {
		
		String sql = "SELECT * FROM employee WHERE id = "+id;
		return super.getJdbcTemplate().queryForObject(sql, new EmployeeMapper());
	}

	@Override
	public boolean insert(Employee t) {
		
		String sql = "INSERT INTO employee(name, age) VALUES(?, ?)";
		return super.getJdbcTemplate().update(sql, t.getName(), t.getAge()) > 0;
	}

	@Override
	public boolean update(Employee t) {
		
		String sql = "UPDATE employee SET name=?, age=? WHERE id=?";
		return super.getJdbcTemplate().update(sql, t.getName(), t.getAge(), t.getId()) > 0;
	}

	@Override
	public boolean delete(int id) {
		
		String sql = "DELETE FROM employee WHERE id=?";
		return super.getJdbcTemplate().update(sql, id) > 0;
	}
}