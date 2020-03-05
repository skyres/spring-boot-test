package com.example.app1.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse<T> {

    private boolean success;
    private String message;
    private T data;

    public ServiceResponse(T req) {
        success = true;
        message = "";
        data = req;
    }
}
