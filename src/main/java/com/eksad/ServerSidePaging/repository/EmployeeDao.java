package com.eksad.ServerSidePaging.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.eksad.ServerSidePaging.model.Employee;

@Repository
@RepositoryRestResource(path="members")
public interface EmployeeDao  extends PagingAndSortingRepository<Employee, Long>{

}
