package com.example.hr1.domain.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.hr1.domain.emp.dto.EmpDetailDTO;
import com.example.hr1.domain.emp.dto.EmpTableDTO;
import com.example.hr1.domain.emp.service.EmpService;

@Controller
public class EmpController {
    
    @Autowired
    private EmpService empService;

    @GetMapping("/emp")
    public ModelAndView getEmpTablePage() {
        ModelAndView modelAndView = new ModelAndView();
        List<EmpTableDTO> empTableDTOList = empService.getEmpTableData();
        modelAndView.addObject("empTableDTOList", empTableDTOList);
        modelAndView.setViewName("emp/emp-list");
        return modelAndView;
    }

    @GetMapping("/emp/{employeeId}")
    public ModelAndView getEmpListPage(@PathVariable Integer employeeId) {
        ModelAndView modelAndView = new ModelAndView();

        EmpDetailDTO empDetailDTO = empService.getEmpDetailData(employeeId);
        modelAndView.addObject("empDetailDTO", empDetailDTO);
        modelAndView.setViewName("emp/emp-detail");

        return modelAndView;
    }

}
