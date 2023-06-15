package com.project.employee.controller;

import com.project.employee.dto.EmployeeDto;
import com.project.employee.dto.GetAllEmployeesDto;
import com.project.employee.entity.Employee;
import com.project.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

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

    @GetMapping("/all")
    public GetAllEmployeesDto getAllEmployee(){

         return GetAllEmployeesDto.builder()
                 .employees(employeeService.getAllEmployee())
                 .build();
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable int id){

        Optional<Employee> employee = employeeService.getEmployeeById(id);

        Supplier<Employee> supplier = ()-> employee.;

        Employee employee1 =  employee.orElseGet(supplier);
        EmployeeDto employeeDto1 = employee1.toDto(employee1);
        return employeeDto1;

    }

}
