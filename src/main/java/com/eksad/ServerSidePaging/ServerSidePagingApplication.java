package com.eksad.ServerSidePaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.eksad.ServerSidePaging.model.Employee;
import com.eksad.ServerSidePaging.repository.EmployeeDao;
import com.eksad.ServerSidePaging.repository.EmployeeRepository;




@SpringBootApplication
public class ServerSidePagingApplication implements ApplicationRunner {
	

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	

	public static void main(String[] args) {
		SpringApplication.run(ServerSidePagingApplication.class, args);
		
		
		
//Page<Employee> page = EmployeeRepository.findAll(PageRequest.of(2, 10, Sort.by("name")));
//		
//		System.out.println("Total element : " + page.getTotalElements());
//		System.out.println("Total page : " + page.getTotalPages());
//		page.forEach(System.out::println);
//		EmployeeRepository.findAll(Sort.by("name")).forEach(System.out::println);
	}



	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		Page<Employee> page = employeeRepository.findAll(PageRequest.of(5, 3, Sort.by("address").ascending()));
		
		System.out.println("Total element : " + page.getTotalElements());
		System.out.println("Total page : " + page.getTotalPages());
		page.forEach(System.out::println);
		employeeRepository.findAll(Sort.by("address")).forEach(System.out::println);
	}

	
}

