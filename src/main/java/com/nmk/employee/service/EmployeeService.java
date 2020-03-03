package com.nmk.employee.service;

import java.util.List;
import java.util.Optional;

import com.nmk.employee.dto.EmployeeDto;
import com.nmk.employee.entity.Employees;
public interface EmployeeService {
	
	public List<Employees> getAllEmployees();
	
  // public Employees RegisterEmployee(Employees employees);
    
    //public Employees getById(Long id);
    
    public void deleteByName(Long id);
    
    public Employees updateEmployee(Employees emp);
    
    public Employees createOrUpdateEmployee(Employees entity);

	Employees getById(String id);
	

	Employees getByIdNoAndName();

	Employees getByIdNoAndName(EmployeeDto dto);
    
   // public Employees  getBYName(String firstName);

}
