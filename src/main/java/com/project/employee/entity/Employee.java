package com.project.employee.entity;

import com.project.employee.dto.EmployeeDto;
import lombok.*;
import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "employee_name", nullable=false)
    private String name;

    @Column
    private Long contact;

    @Column
    private String city;

    @Column(columnDefinition = "varchar(255) default 'India'")
    private String country;

    public EmployeeDto toDto(Employee employee){
        return EmployeeDto.builder()
                .name(employee.getName())
                .contact(employee.getContact())
                .city(employee.getCity())
                .country(employee.getCountry())
                .build();
    }

}
