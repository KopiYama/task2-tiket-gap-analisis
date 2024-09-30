package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessagesResponse {

    private String message;
    private int statusCode;
    private String status;
    private Object data;
    private String errorMessage;
    private Meta meta;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Meta {
        private int totalItems;
        private int totalPages;
        private int currentPage;
        private int lastPage;
    }

    // Constructor for success response without data
    public MessagesResponse(String message, int statusCode, String status) {
        this.message = message;
        this.statusCode = statusCode;
        this.status = status;
    }

    // Constructor for success response with data and meta
    public MessagesResponse(String message, int statusCode, String status, Object data, Meta meta) {
        this.message = message;
        this.statusCode = statusCode;
        this.status = status;
        this.data = data;
        this.meta = meta;
    }

    // Constructor for success response with data and error message (without meta)
    public MessagesResponse(String message, int statusCode, String status, Object data, String errorMessage) {
        this.message = message;
        this.statusCode = statusCode;
        this.status = status;
        this.data = data;
        this.errorMessage = errorMessage;
    }

    // Constructor for success response with data
    public MessagesResponse(String message, int statusCode, String status, Object data) {
        this.message = message;
        this.statusCode = statusCode;
        this.status = status;
        this.data = data;
    }

    // Constructor for error response
    public MessagesResponse(String message, int statusCode, String status, String errorMessage) {
        this.message = message;
        this.statusCode = statusCode;
        this.status = status;
        this.errorMessage = errorMessage;
    }
}
