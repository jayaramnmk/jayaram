package com.nmk.employee.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.RecordTypeNotSupportedException;
import org.springframework.stereotype.Service;

import com.nmk.employee.dto.EmployeeDto;
import com.nmk.employee.entity.Employees;
import com.nmk.employee.repository.EmployeeRepository;
import com.nmk.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public List<Employees> getAllEmployees() {
		List<Employees> employeelist = repository.findAll();
		return employeelist;
	}

	/*
	 * public Employees RegisterEmployee(Employees employees) { Employees
	 * employeesData= repository.save(employees); return employeesData; }
	 */

	@Override
	public Employees getById(String id) {
		Employees emp = repository.findByFirstName(id);
		return emp;
	}

	public void deletByName(Long id) {

		Optional<Employees> emps = repository.findById(id);

		if (emps.isPresent()) {
			repository.deleteById(id);
		}

		else {
			System.out.println("No employee record exist for given id");
		}

	}

	@Override
	public Employees updateEmployee(Employees emp) {

		Optional<Employees> emps = repository.findById(emp.getId());
		if (emps.isPresent()) {

			Employees entity = emps.get();
			entity.setId(emp.getId());
			entity.setEmail(emp.getEmail());
			entity.setFirstName(emp.getFirstName());
			entity.setLastName(emp.getLastName());

		}

		return emp;
	}

	@Override
	public void deleteByName(Long id) {

	}

	@Override
	public Employees createOrUpdateEmployee(Employees entity) throws RecordTypeNotSupportedException {

		Optional<Employees> emps = repository.findById(entity.getId());
		if (emps.isPresent()) {
			Employees newEntity = emps.get();
			newEntity.setIdNo(entity.getIdNo());
			newEntity.setId(entity.getId());
			newEntity.setFirstName(entity.getFirstName());
			newEntity.setLastName(entity.getFirstName());
			newEntity.setEmail(entity.getEmail());
			newEntity.setBloodGroup(entity.getBloodGroup());
			newEntity.setStatus(entity.getStatus());
			newEntity = repository.save(entity);

			return newEntity;
		} else {
			entity = repository.save(entity);

			return entity;
		}

	}

	@Override
	public Employees getByIdNoAndName(EmployeeDto dto) {
		Optional<Employees> emps = repository.findEmployeeIdAndName(dto.getIdNo(), dto.getName());
		Employees e = new Employees();
		if (emps.isPresent()) {
			e = emps.get();
		} else {

			throw new EntityExistsException("not found!");
		}

		return e;
	}

	@Override
	public Employees getByIdNoAndName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Employees create(Employees emp) {
		Employees e = repository.save(emp);
		return e;
	}

	/*
	 * @Override public Employees getBYName(String firstName) { Employees
	 * es=repository.findOne(firstName); return es; }
	 */
	/*
	 * @Override public Employees RegisterEmployee(Employees employees) { // TODO
	 * Auto-generated method stub return null; }
	 */

}
