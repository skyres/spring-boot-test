package com.example.app1.controller;

import com.example.app1.model.RequestModel;
import com.example.app1.model.ResponseModel;
import com.example.app1.model.ServiceResponse;
import com.example.app1.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class AppController {

    private final AppService appService;

    public AppController(AppService appService) {

        this.appService = appService;
    }

    @PostMapping("/")
    ServiceResponse<ResponseModel> home(@RequestBody RequestModel req) {
        return new ServiceResponse<ResponseModel>(new ResponseModel(req.getParam()));
    }

    @GetMapping("/")
    ServiceResponse<String> home() {
        return new ServiceResponse<String>(true,"Hello World!", null);
    }

    @GetMapping("/home/{inp}")
    ServiceResponse<String> home(@PathVariable String inp) {
        return new ServiceResponse<String>(true, inp, null);
    }

    @GetMapping("/home")
    String homeAlone() {
        return "Hello World!";
    }

    @PostMapping("/sum")
    ServiceResponse<Integer> sum(@RequestBody RequestModel req) {

        return new ServiceResponse<Integer>(appService.sum(req.getNum1(), req.getNum2()));
    }

}
