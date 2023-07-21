package com.example.hr1.domain.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hr1.common.dto.ResponseDTO;
import com.example.hr1.domain.main.dto.ReqInserMainDTO;
import com.example.hr1.domain.main.dto.ResMainDTO;
import com.example.hr1.domain.main.service.MainService;

@RestController
public class MainControllerApiV1 {
    
    @Autowired
    private MainService mainService;

    @GetMapping("/api/v1/main")
    public List<ResMainDTO> getMainData() {
        return mainService.getMainPageData();
    }

    @PostMapping("/api/v1/main")
    public ResponseDTO<Object> postMainData(@RequestBody ReqInserMainDTO reqInserMainDTO) {
        // System.out.println(reqInserMainDTO);
        mainService.postMainData(reqInserMainDTO);

        return ResponseDTO.builder()
            .code(0)
            .message("region 등록에 성공했습니다.")
            .build();
    }

    @DeleteMapping("/api/v1/main/{regionId}")
    public ResponseDTO<Object> deleteMainData(@PathVariable Integer regionId) {
        mainService.deleteMainData(regionId);

        return ResponseDTO.builder()
            .code(0)
            .message("region 삭제에 성공했습니다.")
            .build();
    }

}
