package com.restapi.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.employee.dto.ResponseDto;
import com.restapi.employee.entity.Employee;
import com.restapi.employee.exception.DataExistsException;
import com.restapi.employee.exception.DataNotFoundException;
import com.restapi.employee.repository.EmployeeRepository;

@Service
public class Employeeservice {
	@Autowired
	EmployeeRepository repository;
	public ResponseDto save(Employee employee){
	    if(repository.existsByMobileOrEmail(employee.getMobile(), employee.getEmail()))
	        throw new DataExistsException("Employee already exists with same mobile or email");

	    Employee savedEmployee = repository.save(employee);  // <-- save to DB
	    return new ResponseDto("Data Added Successfully", savedEmployee);
	}

	
	public ResponseDto fetchAll() {
		List<Employee> employees=repository.findAll();
    	if(employees.isEmpty())
    		throw new DataNotFoundException("No Data Present");
    	else
    		return new ResponseDto("Data Found", employees);
    }


	public ResponseDto fetchById(Integer id) {
		Employee employee=repository.findById(id).orElseThrow(()-> new DataNotFoundException("No Record Found  with id:" +id));
		return  new ResponseDto("Data Found ", employee);
	}


	public ResponseDto fetchByDepartment(String dept) {
		List<Employee> employee= repository.findByDepartment(dept);
		if(employee.isEmpty())
			throw new DataNotFoundException("No Data Present with Department :" +dept);
		return  new ResponseDto("Data Found ", employee);
	}


	public void deleteById(Integer id) {
		repository.findById(id).orElseThrow(()-> new DataNotFoundException("No Record Found  with id:" +id));	
	  repository.deleteById(id);	
	
	}


	public ResponseDto updateCompletely(Integer id, Employee employee) {
		repository.findById(id).orElseThrow(()-> new DataNotFoundException("No Record Found  with id:" +id));	
employee.setId(id);//Mandatory , otherwise it will take as new record
repository.save(employee);
return new ResponseDto("Data uploaded successfully ", employee); 


	}


	public ResponseDto updatePartially(Integer id, Employee employee) {
	Employee exemployee	=repository.findById(id).orElseThrow(()-> new DataNotFoundException("No Record Found  with id:" +id));	
	exemployee.setDepartment(employee.getDepartment()==null ? exemployee.getDepartment():employee.getDepartment());
	exemployee.setEmail(employee.getEmail()==null ? exemployee.getEmail():employee.getEmail());
	exemployee.setSalary(employee.getSalary()==null ? exemployee.getSalary():employee.getSalary());
	exemployee.setMobile(employee.getMobile()==null ? exemployee.getMobile():employee.getMobile());
	exemployee.setName(employee.getName()==null ? exemployee.getName():employee.getName());
	repository.save(exemployee);
	
	return  new ResponseDto("Data Updated Successfully", exemployee);
	}
	}