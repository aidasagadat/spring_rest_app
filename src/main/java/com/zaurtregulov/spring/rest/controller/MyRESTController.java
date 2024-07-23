package com.zaurtregulov.spring.rest.controller;

import com.zaurtregulov.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

}
