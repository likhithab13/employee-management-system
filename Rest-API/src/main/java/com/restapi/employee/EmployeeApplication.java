package com.restapi.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Employee Management Rest API", version="0.0.1", description="ARest Api which performoperation crud with  employee records" , 
contact= @Contact (name="Tejaswini kv" ,email="tejaswinikv90@gmail.com")))
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class,args);
	}

}