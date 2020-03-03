package com.nmk.employee.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nmk.employee.dto.EmployeeDto;
import com.nmk.employee.entity.Employees;
import com.nmk.employee.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping(value = "/api/v1/employee", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeService;

	@GetMapping("/all")
	public List<Employees> getAllEmployees() {
		System.out.println("EmployeeController.getAllEmployees()");
		return employeeService.getAllEmployees();
	}

	@GetMapping("/details/{name}")
	public Employees getById(@PathVariable("name") String name) {
		return employeeService.getById(name);
	}

	@DeleteMapping("/{id}")
	public String deletByName(@PathVariable("id") Long id) {
		employeeService.deletByName(id);
		return "Record Deleted" + id;
	}

	@PutMapping("/putting")
	public Employees updateEmployee(Employees emp) {
		return employeeService.updateEmployee(emp);

	}

	@PostMapping("/employee")
	public Employees save(@RequestBody Employees emp) {
		Employees employee = employeeService.create(emp);
		return employee;

	}

	@PostMapping("/byIdAndname")
	public Employees getByIdNoandName(@RequestBody EmployeeDto dto) {
		Employees emp = employeeService.getByIdNoAndName(dto);
		return emp;

	}

}
