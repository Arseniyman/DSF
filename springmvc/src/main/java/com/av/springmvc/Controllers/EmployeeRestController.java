package com.av.springmvc.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.av.springmvc.DAO.JdbcEmployeeDao;
import com.av.springmvc.Models.Employee;

@RestController
@RequestMapping("/api/employee/")
public class EmployeeRestController {
	
	private JdbcEmployeeDao dao;

	@Autowired
	public void setDao(JdbcEmployeeDao dao) {
		this.dao = dao;
	}

	@GetMapping("/all")
	public List<Employee> getAll() {
		
		return dao.getAll();
	}
	
	@GetMapping("{id}")
	public Employee getById(@PathVariable("id") int id) {
		
		Employee employee = dao.getById(id);
		
		return employee;
	}
	
	@PostMapping("/create")
	public void createEmployee(@ModelAttribute Employee employee) {
		
		dao.insert(employee);
	}
	
	@PostMapping("/employee/update")
	public void updateEmployee(@ModelAttribute Employee employee) {
		
		dao.update(employee);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable("id") int id) {
		
		dao.delete(id);
	}
}