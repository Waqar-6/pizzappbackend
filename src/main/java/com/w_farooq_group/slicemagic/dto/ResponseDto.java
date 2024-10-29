package com.w_farooq_group.slicemagic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ResponseDto {
    private String responseStatus;
    private String responseMessage;
}
