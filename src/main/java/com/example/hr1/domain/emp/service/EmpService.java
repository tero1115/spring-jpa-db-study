package com.example.hr1.domain.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hr1.domain.emp.dto.EmpDetailDTO;
import com.example.hr1.domain.emp.dto.EmpTableDTO;
import com.example.hr1.model.employees.entity.EmployeesEntity;
import com.example.hr1.model.employees.repository.EmployeesRepository;

@Service
public class EmpService {
    
    @Autowired
    private EmployeesRepository employeesRepository;

    public List<EmpTableDTO> getSearchEmpTableData(String firstName){
        // firstName이 null이면 findAll
        // firstName이 null이 아니면 findByFirstName~
        if (firstName == null) {
            return EmpTableDTO.fromEntityList(employeesRepository.findAll());
        } else {
            return EmpTableDTO.fromEntityList(employeesRepository.findByFirstNameContainingIgnoreCase(firstName));
        }
    }
    public List<EmpTableDTO> getEmpTableData(){
        return EmpTableDTO.fromEntityList(employeesRepository.findAll());
    }
    
    public EmpDetailDTO getEmpDetailData(Integer employeeId){
        Optional<EmployeesEntity> employeesEntityOptional = employeesRepository.findById(employeeId);

        if (!employeesEntityOptional.isPresent()) {
            throw new RuntimeException("잘못된 요청입니다.");
        }
        return EmpDetailDTO.fromEntity(employeesEntityOptional.get());
    }
}
