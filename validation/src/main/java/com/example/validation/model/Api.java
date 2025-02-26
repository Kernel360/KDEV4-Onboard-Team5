package com.example.validation.model;

import jakarta.validation.Valid;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Api<T> {

    private String resultCode;
    private String resultMessage;

    @Valid
    private T data;

    private Error error;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Error {
        private List<String> errorMessage;
    }
}
