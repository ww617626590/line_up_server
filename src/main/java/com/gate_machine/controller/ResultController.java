package com.gate_machine.controller;

import com.gate_machine.result.R;
import com.gate_machine.service.LgResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wanghao
 * @date: 2024/5/18 22:04
 * @description:
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private LgResultService lgResultService;


    /**
     * 结果分页
     * @param page 当前页
     *             pageSize 每页显示多少条
     *             suanfa 查询字段
     */
    @GetMapping("/page")
    public Object page(int page, int pageSize, String suanfa, String data) {
        return R.success(lgResultService.pageMain(page, pageSize, suanfa, data));
    }

}