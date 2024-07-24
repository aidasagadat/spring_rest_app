package com.zaurtregulov.spring.rest.controller;

import com.zaurtregulov.spring.rest.entity.Employee;
import com.zaurtregulov.spring.rest.exception_handling.ExceptionInformation;
import com.zaurtregulov.spring.rest.exception_handling.NoSuchEmployeeException;
import com.zaurtregulov.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }


    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);

        if(employee == null){
            throw new NoSuchEmployeeException("Employee with id " + id + " not found");
        }

        return employee;

    }

    @ExceptionHandler
    public ResponseEntity<ExceptionInformation> handleException(NoSuchEmployeeException exception){

        ExceptionInformation exceptionInformation = new ExceptionInformation();

        exceptionInformation.setInformation(exception.getMessage());

        return new ResponseEntity<>(exceptionInformation, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<ExceptionInformation> handleException(Exception exception){
        ExceptionInformation exceptionInformation = new ExceptionInformation();
        exceptionInformation.setInformation(exception.getMessage());

        return new ResponseEntity<>(exceptionInformation, HttpStatus.BAD_REQUEST);
    }


}





















