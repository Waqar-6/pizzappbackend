package com.w_farooq_group.slicemagic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
public class ErrorResponseDto {
    private String apiPathInvoked;
    private HttpStatus errorStatus;
    private String errorMessage;
    private LocalDateTime errorTime;
}
