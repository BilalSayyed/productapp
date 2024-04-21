package com.bca.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ErrorInfo {
    private String errorMessage;
    private String toContact;
    private String status;
    private LocalDateTime timestamp;
}
