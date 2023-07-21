package com.example.hr1.domain.main.dto;

import com.example.hr1.model.regions.entity.RegionsEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ResUpdateMainDTO {
    private Integer regionId;
    private String regionName;

    public static ResUpdateMainDTO fromEntity(RegionsEntity regionsEntity){
        return new ResUpdateMainDTO(regionsEntity.getRegionId(), regionsEntity.getRegionName());
    }
}
