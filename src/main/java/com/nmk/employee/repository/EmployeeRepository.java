package com.nmk.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nmk.employee.entity.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Long> {


	Employees findByFirstName( String firstname);

	@Query("select e from Employees e where e.idNo = ?1 and e.firstName = ?2")
	Optional<Employees> findEmployeeIdAndName( String idNo,  String name);

	
}