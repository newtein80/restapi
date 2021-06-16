package com.nile.apiservice.sample.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "샘플 상세 정보 DTO", description = "샘플 Data Transfer Object")
public class SampleDTO {
    @ApiModelProperty(position = 1, notes = "제목")
    private String sampleTitle;
    @ApiModelProperty(position = 2, notes = "내용")
    private String sampleContent;
    @ApiModelProperty(position = 3, notes = "조회수")
    private Long viewcount;
}
