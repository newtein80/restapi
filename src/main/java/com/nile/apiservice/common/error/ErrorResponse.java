package com.nile.apiservice.common.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
@ApiModel(value = "API 응답 모델 - Error", description = "API 에러 응답 모델")
public class ErrorResponse {
    @ApiModelProperty(position = 1, notes = "현재 시간") // position: 문서상에 보이는 순서. notes : 설명
    private final LocalDateTime timestamp;
    @ApiModelProperty(position = 2, notes = "응답 상태")
    private final int status;
    @ApiModelProperty(position = 3, notes = "응답 코드")
    private final String error;
    @ApiModelProperty(position = 4, notes = "응답 메시지")
    private final String message;

    public ErrorResponse(HttpStatus httpStatus, String errCode, String message) {
        this.timestamp = LocalDateTime.now();
        this.status = httpStatus.value();
        this.error = errCode;
        this.message = message;
    }
}