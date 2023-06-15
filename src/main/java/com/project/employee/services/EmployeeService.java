package com.project.employee.services;

import com.project.employee.dto.EmployeeDto;
import com.project.employee.entity.Employee;
import com.project.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {

        List <Employee> list = employeeRepository.findAll();

        return list;

    }

    public Optional<Employee> getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee;
    }

}
