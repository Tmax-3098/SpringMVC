package com.saturn.springweb.advices;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    private T apiResponse;

    private ApiError error;

    private LocalDateTime timestamp;


    public ApiResponse(T apiResponse) {
        this();
        this.apiResponse = apiResponse;
    }

    public ApiResponse(ApiError error) {
        this();
        this.error = error;
    }

    public ApiResponse() {
        this.timestamp = LocalDateTime.now();
    }
}
