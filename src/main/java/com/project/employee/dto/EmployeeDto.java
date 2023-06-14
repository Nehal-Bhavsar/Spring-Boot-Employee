package com.project.employee.dto;

import com.project.employee.entity.Employee;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {

    private String name;

    private String city;

    private long contact;

    private String country;

    public Employee toEntity(EmployeeDto employeeDto) {
        return Employee.builder()
                .name(employeeDto.getName())
                .contact(employeeDto.getContact())
                .city(employeeDto.getCity())
                .country(employeeDto.getCountry())
                .build();
    }
}
