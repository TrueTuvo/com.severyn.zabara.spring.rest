package com.severyn.zabara.spring.rest.controllers;

import com.severyn.zabara.spring.rest.entity.Employee;
import com.severyn.zabara.spring.rest.exceptionHandling.EmployeeIncorrectData;
import com.severyn.zabara.spring.rest.exceptionHandling.NoSuchEmployeeException;
import com.severyn.zabara.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    @Autowired
    private EmployeeService service;

    @RequestMapping("/employees")
    public List<Employee> showAllEmployees() {

        List<Employee> employees = service.getAllEmployees();

        return employees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = service.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("there is no employee with ID = " + id + " in Database");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        service.saveEmployee(employee);
        return employee;
    }

    @PutMapping ("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        service.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {

        Employee employee = service.getEmployee(id);
        if (employee == null){
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in database");
        }
        service.deleteEmployee(id);
        return "Employee with id: " + id + " has been deleted";
    }
}