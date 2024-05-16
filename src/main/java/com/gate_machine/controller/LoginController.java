package com.gate_machine.controller;


import com.gate_machine.domain.User;
import com.gate_machine.handle.AlgorithmHandle;
import com.gate_machine.result.bizResult.CalculateResult;
import com.gate_machine.result.tips.SuccessTip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoginController {


    @Autowired
    AlgorithmHandle algorithmHandle;
    /**
     *
     * 这是个登录接口
     */
    @PostMapping("/login")
    public Object login(@RequestBody User user){
        return new SuccessTip();
    }
    @GetMapping("/test")
    public Object passTime(){
        return new SuccessTip();
    }
    /**
     *
     * 获取平均时间的接口
     */
    @GetMapping("/passTime")
    public Object passTime(String type){
        CalculateResult result = algorithmHandle.mM1(type);
        return new SuccessTip().data(result);
    }
}
