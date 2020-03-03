package com.nmk.employee.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Employees {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String idNo;

	private String firstName;

	private String LastName;

	private String email;

	private String bloodGroup;

	private Boolean status;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

	@JoinColumn(name = "AddressID")
	private List<Address> employeeAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<Address> getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(List<Address> employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", idNo=" + idNo + ", firstName=" + firstName + ", LastName=" + LastName
				+ ", email=" + email + ", bloodGroup=" + bloodGroup + ", status=" + status + ", employeeAddress="
				+ employeeAddress + "]";
	}

}
