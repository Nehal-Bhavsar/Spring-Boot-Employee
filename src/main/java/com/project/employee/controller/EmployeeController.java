package com.project.employee.controller;

import com.project.employee.dto.EmployeeDto;
import com.project.employee.entity.Employee;
import com.project.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping()
    public String welcome(){
        return "Welcome to the Employee Application!";
    }

    @PostMapping("/create")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto){

        Employee employee = employeeDto.toEntity(employeeDto);
        Employee employee1 = employeeService.create(employee);
        EmployeeDto employeeDto1 = employee.toDto(employee1);

        return employeeDto1;
    }

}
