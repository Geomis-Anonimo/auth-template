package br.com.auth.infra.dto;

import lombok.Data;

@Data
public class ErrorResponse {
    private int status;
    private String message;
    private Long timestamp;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }
}

