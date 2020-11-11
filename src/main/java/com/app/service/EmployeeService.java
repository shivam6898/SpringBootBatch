package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Employee;
import com.app.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepository;

	/*
	 * @Transactional public String insertEmployee() { for (int i = 1; i <=50; i++)
	 * { Employee employee=new Employee(); employee.setEmpName("empname"+i);
	 * employee.setEmpSal(i+0.5); employeeRepo.save(employee) ; } return
	 * "All Employees saved one by one"; }
	 */
	
	
	
	@Transactional
	public List<Employee> insertEmployeeInBatch(List<Employee> empList) {
		long start = System.currentTimeMillis();
		List<Employee> insertedList = employeeRepository.saveAll(empList);
		System.out.println("Time taken by InsertInBatch--" +  (System.currentTimeMillis() - start));
		return insertedList;
	}
	 
	
	

	@Transactional
	public List<Employee> updateAll(List<Employee> employee) {
		return employeeRepository.saveAll(employee);
	}


	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}	
	
	
	@Transactional
	public void deleteInBatch(List<Employee> empList) {
		long start = System.currentTimeMillis();
		employeeRepository.deleteInBatch(empList);
		long end = System.currentTimeMillis();
		System.out.println("Time taken by deleteInBatch--" + (int) (end - start));
	}



	/*
	 * public boolean updateAll(List<Employee> emp) { try {
	 * employeeRepo.saveAll(emp); return true; } catch (Exception e) { return false;
	 * } }
	 */
	
	

	/*
	 * @Transactional public String updateEmployees(List<Employee> empList) {
	 * List<Employee> updatedemp= employeeRepo.saveAll(empList); for (Employee
	 * employee : updatedemp) { employee.getEmpId()==
	 * 
	 * } }
	 */

}
