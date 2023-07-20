package com.example.hr1.model.employees.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hr1.model.employees.entity.EmployeesEntity;



@Repository
public interface EmployeesRepository extends JpaRepository<EmployeesEntity, Integer>{
    
    Optional<EmployeesEntity> findByEmployeeId(Integer employeeId);

}
