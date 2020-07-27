package com.av.springmvc.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.av.springmvc.Models.Employee;

public class EmployeeDao implements Dao<Employee> {
	
	@Override
	public Employee getById(int id) {
		
		Employee employee = null;
		Connection connection = null;
		PreparedStatement prepSate = null;
		ResultSet resultSet = null;
		
		try {
			String sql = "SELECT * FROM employee WHERE id = ?";
			prepSate = connection.prepareStatement(sql);
			prepSate.setInt(1, id);
			resultSet = prepSate.executeQuery();
			
			if (resultSet.next()) {
				int empId = resultSet.getInt(1);
				String name = resultSet.getString(2);
				short age = resultSet.getShort(3);
				employee = new Employee(empId, name, age);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				prepSate.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employee;
	}

	@Override
	public ArrayList<Employee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Employee t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Employee t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Employee t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static Connection getConn() throws SQLException {
        return (DriverManager.getConnection("jdbc:mysql://localhost:3376/sandbox?user=root&password=root"));
    }
}