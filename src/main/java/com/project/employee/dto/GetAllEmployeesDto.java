package com.project.employee.dto;

import com.project.employee.entity.Employee;
import lombok.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllEmployeesDto {
    List<Employee> employees;
}
