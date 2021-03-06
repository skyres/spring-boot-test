package com.example.app1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestModel {

    private String param;
    private int num1;
    private int num2;

    @Override
    public String toString() {
        return "RequestModel{" + "param='" + param + '\'' + ", num1=" + num1 + ", num2=" + num2 + '}';
    }
}
