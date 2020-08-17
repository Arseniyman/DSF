package com.av.springmvc.Models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		int id = rs.getInt("id");
		String name = rs.getString("name");
		short age = rs.getShort("age");
		
		return new Employee(id, name, age);

	}
}