package com.project.employee.entity;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.project.employee.dto.EmployeeDto;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Optional;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@DynamicInsert
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
    @PrePersist
    void prePersist(){
        if(this.country == null || this.country == ""){
            this.country = "India";
        }
    }

    public EmployeeDto toDto(Employee employee){
        return EmployeeDto.builder()
                .name(employee.getName())
                .contact(employee.getContact())
                .city(employee.getCity())
                .country(employee.getCountry())
                .build();
    }

    
}
