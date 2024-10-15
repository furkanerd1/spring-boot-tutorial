package com.example.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.cruddemo.entity.Employee;

@Repository
//@RepositoryRestResource(path="member")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
