package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	//insert one by one
	/*
	 * @PostMapping("insert") public String insertEmp() { return
	 * employeeService.insertEmployee(); }
	 */

	//insert in batch
	@PostMapping("insertinbatch")
	public String inserEmpInBatch() {
		return employeeService.insertEmployeeInBatch();
	}
	
	
	@GetMapping("/getall")
	public ResponseEntity<?>  getAllEmployees(){
		ResponseEntity<?> resp =null;
		List<Employee> list=employeeService.getAllEmployees();
		if(list==null && list.isEmpty() ) {
			String msg="NO DATA FOUND";
			resp=new ResponseEntity<String>(msg,HttpStatus.NO_CONTENT);
		}else {
			resp=new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
		}

		return resp;
	}

	//get in batch
	
	/*
	 * @GetMapping("findallemployees") public List<Employee> getAllPeople() { return
	 * employeeService.findAllEmployees(); }
	 */
	 

	//insert in batch
	/*
	 * @PostMapping("bulkinsert") public String addPeople(@RequestBody
	 * List<Employee> employee) { if(employee != null && !employee.isEmpty()) {
	 * employeeService.insertAll(employee); return "employees saved"; } else {
	 * return "NO_DATA_IN_REQUEST"; } }
	 */


	

	@PutMapping("update")
	public String updatePeople(@RequestBody List<Employee> employee) {
		if (employee != null) {
			employeeService.updateAll(employee);
			return "Updated employees.";
		} else {
			return "REQUEST_NO_BODY";
		}
	}

	
	

	/*
	 * //update employee data
	 * 
	 * @PutMapping("/updateemployee") public String updateEmployee(@RequestBody
	 * List<Employee> empList){ return employeeService.updateEmployees(empList) ; }
	 */

}
