package com.av.springmvc.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.av.springmvc.DAO.JdbcEmployeeDao;
import com.av.springmvc.Models.Employee;

@Controller
@RequestMapping("/")
public class EmployeeController {
	
	private JdbcEmployeeDao dao;

	@Autowired
	public void setDao(JdbcEmployeeDao dao) {
		this.dao = dao;
	}
	
	@GetMapping()
	public String getAllEmployees(Model model) {
		
		List<Employee> employees = dao.getAll();
		model.addAttribute("employees", employees);
		return "employee/index";
	}
	
	@GetMapping("employee/create")
	public String getCreatePage(Model model) {
		
		model.addAttribute("employee", new Employee());
		return "employee/create";
	}
	
	@PostMapping("employee/create")
	public String createEmployee(@ModelAttribute Employee employee, Model model) {
		
		dao.insert(employee);
		return "redirect:/";
	}
	
	@GetMapping("employee/details/{id}")
	public String getEmployeeDetails(@PathVariable("id") int id, Model model) {
		
		Employee employee = dao.getById(id);
		model.addAttribute("employee", employee);
		return "employee/details";
	}
	
	
	@PostMapping("/employee/update")
	public String updateEmployee(@ModelAttribute Employee employee) {
		
		dao.update(employee);
		return "redirect:/employee/details/" + employee.getId();
	}
	
	@GetMapping("/employee/delete")
	public String deleteEmployee(@RequestParam(value = "id") int id) {
		dao.delete(id);
		return "redirect:/";
	}
}