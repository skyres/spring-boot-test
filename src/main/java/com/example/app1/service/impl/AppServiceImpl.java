package com.example.app1.service.impl;

import com.example.app1.service.AppService;
import org.springframework.stereotype.Service;

@Service
public class AppServiceImpl implements AppService {

    @Override
    public int sum(int num1, int num2) {

        return num1 + num2;
    }

    @Override
    public int multiply(int num1, int num2) {
        return num1 * num2;
    }
}
