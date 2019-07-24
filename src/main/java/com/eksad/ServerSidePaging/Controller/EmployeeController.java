package com.eksad.ServerSidePaging.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eksad.ServerSidePaging.exception.DataNotFoundException;
import com.eksad.ServerSidePaging.model.Employee;
import com.eksad.ServerSidePaging.repository.EmployeeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(tags = "Employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@ApiOperation(
			value = "API to retrieve Employee data by Employee Id",
		    notes = "Return data with JSON Format",
		    tags = "Get Data API"
			)
	@GetMapping("/getAll")
	public List<Employee> getAllEmployees(){
		return employeeRepo.findAll();
	}
//===================================================================================================================
	@ApiOperation(
			value = "API to retrieve Employee data by Employee id",
		    notes = "Return data with JSON Format",
		    tags = "Get Data API"
			)
	@GetMapping("/getById/{id}")
	public ResponseEntity<Employee> GetEmployeeById(@PathVariable(value = "id")Long employeeId)
			throws DataNotFoundException{
		Employee employee = employeeRepo.findById(employeeId)
				.orElseThrow(() -> new DataNotFoundException("Employee not found for this id :: " + employeeId));

		return ResponseEntity.ok().body(employee);
	}
//===================================================================================================================
	@ApiOperation(
			value = "Saving Employee's data",
		    notes = "Saving Employee's data to database",
		    tags = "Data Manipulation API"
			)
	@PostMapping("/Add")
	public Employee InsertEmployee(@Valid @RequestBody Employee employee) {
	
		Employee saveemployee = new Employee();
		saveemployee.setId(employee.getId());
		saveemployee.setAddress(employee.getAddress());
		saveemployee.setName(employee.getName());
		saveemployee.setPhone(employee.getPhone());
		saveemployee.setAge(employee.getAge());
		saveemployee.setPob(employee.getPob());
		saveemployee.setSalary(employee.getSalary());
		saveemployee.setDivision(employee.getDivision());
		saveemployee.setStatus(employee.getStatus());
		saveemployee.setSex(employee.getSex());
		
		return employeeRepo.save(saveemployee);
	}
//===================================================================================================================
	@ApiOperation(
			value = "Delete Employee's data",
		    notes = "Delete Employee's data to database",
		    tags = "Data Manipulation API"
			)
	@DeleteMapping("/Delete/{id}")
	public Map<String, Boolean> deteleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws DataNotFoundException{
		   		Employee employee = employeeRepo.findById(employeeId)
			       .orElseThrow(() -> new DataNotFoundException("Employee not found for this id :: " + employeeId));

			    employeeRepo.delete(employee);
			    Map<String, Boolean> response = new HashMap<>();
			    response.put("deleted", Boolean.TRUE);
			    return response;
	}
//===================================================================================================================
	@ApiOperation(
			value = "Update Employee's data",
		    notes = "Update Employee's data to database",
		    tags = "Data Manipulation API"
			)
	@PutMapping("/Update/{id}")
	public ResponseEntity<Employee> UpdateEmployee(@Valid @RequestBody Employee employeeRequest, @PathVariable(value = "id") Long employeeId) throws DataNotFoundException {
		
		 Employee employee = employeeRepo.findById(employeeId)
			        .orElseThrow(() -> new DataNotFoundException("Employee not found for this id :: " + employeeId));
		
			employee.setAddress(employeeRequest.getAddress());
			employee.setAge(employeeRequest.getAge());
			employee.setDivision(employeeRequest.getDivision());
			employee.setDob(employeeRequest.getDob());
			employee.setName(employeeRequest.getName());
			employee.setPhone(employeeRequest.getPhone());
			employee.setSalary(employeeRequest.getSalary());
			employee.setPob(employeeRequest.getPob());
			employee.setStatus(employeeRequest.getStatus());
			employee.setSex(employeeRequest.getSex());
			
			final Employee updateEmployee = employeeRepo.save(employee);

		
		return ResponseEntity.ok().body(updateEmployee);
	}
}
