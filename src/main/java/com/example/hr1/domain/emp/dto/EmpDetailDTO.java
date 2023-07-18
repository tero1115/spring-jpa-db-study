package com.example.hr1.domain.emp.dto;

import java.time.LocalDateTime;

import com.example.hr1.model.employees.entity.EmployeesEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class EmpDetailDTO {
    
    private Integer employeeId;

    private String firstName;

    private String lastName;
    
    private LocalDateTime hireDate;
    
    private Integer salary;
    
    private Integer commissionPct;
    
    private Integer managerId;
    
    private Integer departmentId;


    public static EmpDetailDTO fromEntity(EmployeesEntity empEntity){
    return EmpDetailDTO.builder()
                    .employeeId(empEntity.getEmployeeId())
                    .firstName(empEntity.getFirstName())
                    .lastName(empEntity.getLastName())
                    .hireDate(empEntity.getHireDate())
                    .salary(empEntity.getSalary())
                    .commissionPct(empEntity.getCommissionPct())
                    .managerId(empEntity.getManagerId())
                    .departmentId(empEntity.getDepartmentId())
                    .build();
    }
    
}
