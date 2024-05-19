package com.gate_machine.controller;

import com.gate_machine.domain.LgResult;
import com.gate_machine.handle.AlgorithmHandle;
import com.gate_machine.result.R;
import com.gate_machine.result.bizResult.CalculateResult;
import com.gate_machine.service.LgResultService;
import com.gate_machine.service.TimeDataService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Objects;

/**
 * @author: wanghao
 * @date: 2024/5/18 13:01
 * @description:
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/calculate")
public class CalculateController {

    @Autowired
    private AlgorithmHandle algorithmHandle;
    @Autowired
    private LgResultService lgResultService;
    /**
     * 数据计算
     * @param type 选择对应的排队数据
     * @param c 队列长度 非必填
     * @param arithmetic 选择对应的计算方式
     * @return CalculateResult
     */
    @GetMapping("/")
    public Object calculate(String type, Integer c, String arithmetic) {
        CalculateResult calculateResult = new CalculateResult();
        LgResult lgResult = new LgResult();
        if ("mM1".equals(arithmetic)) {
            lgResult.setSf("mM1");
            calculateResult = algorithmHandle.mM1(type);
        } else if ("mMC".equals(arithmetic)) {
            lgResult.setSf("mMC");
            calculateResult = algorithmHandle.mMC(type, c);
        } else if ("mG1".equals(arithmetic)) {
            lgResult.setSf("mG1");
            calculateResult = algorithmHandle.mG1(type);
        }
        if (Objects.nonNull(calculateResult)) {
            lgResult.setU(calculateResult.getU());
            lgResult.setR(calculateResult.getR());
            lgResult.setP(calculateResult.getP());
            lgResult.setL(calculateResult.getL());
            lgResult.setP0(calculateResult.getP0());
            lgResult.setLq(calculateResult.getLq());
            lgResult.setW(calculateResult.getW());
            lgResult.setWq(calculateResult.getWq());
            lgResult.setType(type);
            lgResult.setCreateTime(new Date());
            lgResultService.save(lgResult);
        }
        return R.success(calculateResult);
    }

}
