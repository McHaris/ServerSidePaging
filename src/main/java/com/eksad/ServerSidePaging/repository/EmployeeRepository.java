package com.eksad.ServerSidePaging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.eksad.ServerSidePaging.model.Employee;

@RepositoryRestResource(path= "members")
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
