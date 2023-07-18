package com.example.hr1.domain.emp.dto;

import java.util.List;

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
public class EmpTableDTO {

    private Integer employeeId;
    
    private String firstName;
    
    public static EmpTableDTO fromEntity(EmployeesEntity empEntity){
        return EmpTableDTO.builder()
            .employeeId(empEntity.getEmployeeId())
            .firstName(empEntity.getFirstName())
            .build();
    }

    public static List<EmpTableDTO> fromEntityList(List<EmployeesEntity> employeesEntityList) {
        return employeesEntityList
            .stream()
            .map((employeesEntity)-> fromEntity(employeesEntity))
            .toList();
    }
    
}
