package com.severyn.zabara.spring.rest.controllers;

import com.severyn.zabara.spring.rest.entity.Employee;
import com.severyn.zabara.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    private EmployeeService service;

    @RequestMapping("/employees")
    public List<Employee> showAllEmployees(){

        List<Employee> employees = service.getAllEmployees();

        return employees;
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = service.getEmployee(id);
        return employee;
    }





}
