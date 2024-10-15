package com.example.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.cruddemo.dao.EmployeeRepository;
import com.example.springboot.cruddemo.entity.Employee;

import jakarta.transaction.Transactional;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result =employeeRepository.findById(id);
		Employee thEmployee= null;
		
		if(result.isPresent()) {
			thEmployee=result.get();
		}else {
			throw new RuntimeException("Did not find employee id - " + id);
	}
		return thEmployee;
	}


	@Override
	@Transactional
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
		
	}

	@Override
	@Transactional
	public void delete(int id) {
		employeeRepository.deleteById(id);
		
	}


}
