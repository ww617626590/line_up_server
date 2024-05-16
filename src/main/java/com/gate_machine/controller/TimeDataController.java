package com.gate_machine.controller;


import com.gate_machine.service.TimeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timeData")
public class TimeDataController {

    @Autowired
    private TimeDataService timeDataService;

}
