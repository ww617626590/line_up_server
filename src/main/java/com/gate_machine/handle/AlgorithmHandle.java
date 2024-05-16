package com.gate_machine.handle;


import com.gate_machine.domain.TimeData;
import com.gate_machine.result.bizResult.CalculateResult;
import com.gate_machine.service.TimeDataService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 算法处理
 *
 * @author xxxx
 */
@Component
public class AlgorithmHandle {

    @Autowired
    private TimeDataService timeDataService;

    // 定义一个常量1
    private static final BigDecimal ONE = new BigDecimal(1);


    /**
     * M/M/1
     * 顾客到达时间间隔/服务时间分布：指数分布/服务台数目：1
     *
     * @param type 对应的排队方式：1-检票闸机，2-安检设施 3-自动售票机
     */
    public CalculateResult mM1(String type) {
        CalculateResult calculateResult = new CalculateResult();
        List<TimeData> timeDataList = timeDataService.selectByType(type);
        BigDecimal u = getU(timeDataList);
        calculateResult.setU(u);
        BigDecimal r = getR(timeDataList);
        calculateResult.setR(r);
        // 求p的值 r / u
        BigDecimal p = r.divide(u, 5, BigDecimal.ROUND_HALF_UP);
        calculateResult.setP(p);
        // 求L的值 p / 1- p
        BigDecimal L = p.divide(new BigDecimal(1).subtract(p), 5, BigDecimal.ROUND_HALF_UP);
        calculateResult.setL(L);
        // 求Lq的值 P的平方 / u(1-p)
        BigDecimal Lq = p.multiply(p).divide(new BigDecimal(1).subtract(p), 5, BigDecimal.ROUND_HALF_UP);
        calculateResult.setLq(Lq);
        // 求W的值 1 / u(1-p)
        BigDecimal W = new BigDecimal(1).divide(u.multiply(new BigDecimal(1).subtract(p)), 5, BigDecimal.ROUND_HALF_UP);
        calculateResult.setW(W);
        // 求Wq的值 p / u(1-p)
        BigDecimal Wq = p.divide(u.multiply(new BigDecimal(1).subtract(p)), 5, BigDecimal.ROUND_HALF_UP);
        calculateResult.setWq(Wq);
        return calculateResult;
    }


    /**
     * M/M/C
     * 顾客到达时间间隔/服务时间分布：指数分布/服务台数目：C个
     *
     * @param type 对应的排队方式：1-检票闸机，2-安检设施 3-自动售票机
     * @param c    服务台数目
     */
    public CalculateResult mMC(String type, int c) {
        CalculateResult calculateResult = new CalculateResult();
        List<TimeData> timeDataList = timeDataService.selectByType(type);
        // 求取passTime 的平均值 stream实现
        BigDecimal u = getU(timeDataList);
        calculateResult.setU(u);
        BigDecimal r = getR(timeDataList);
        calculateResult.setR(r);
        // 求p*的值 r / (c * u)
        BigDecimal p = r.divide(new BigDecimal(c).multiply(u), 5, BigDecimal.ROUND_HALF_UP);
        calculateResult.setP(p);
        BigDecimal p0 = getP0(u, r, p, c);

        // 求Lq值
        // 先求 (c * p)c次幂 * p




        return calculateResult;
    }

    private BigDecimal getP0(BigDecimal u, BigDecimal r, BigDecimal p, Integer c) {
        BigDecimal p0 = new BigDecimal(1);
        // 把p0分成两个部分 (part1 + part2) -1次幂

        //part2 = Z1 * Z2 * Z3
        // Z1 =  1 除以 C!
        BigDecimal Z1 = p0.divide(new BigDecimal(gteFactorial(c)), 5, BigDecimal.ROUND_HALF_UP);

        // Z2 = 1 除以 （1-p）
        BigDecimal Z2 = p0.divide(new BigDecimal(1).subtract(p), 5, BigDecimal.ROUND_HALF_UP);

        // Z3 = r / u 的 c 次方
        // r /u
        BigDecimal Z3 = r.divide(u, 5, BigDecimal.ROUND_HALF_UP);
        // z3 的 c次方
        BigDecimal Z3_c = Z3.pow(c);
        BigDecimal part2 = Z1.multiply(Z2).multiply(Z3_c);

        // 求part1的值
        BigDecimal part1 = this.calculateSum(c - 1, r, u);
        // p0 = (part1 + part2) -1次幂
        p0 = part1.add(part2).pow(-1);
        return p0;
    }

    /**
     * 求和公式
     */
    public BigDecimal calculateSum(int x, BigDecimal r, BigDecimal u) {
        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i <= x; i++) {
            // 1 / i阶乘
            BigDecimal oneDivideI = ONE.divide(new BigDecimal(gteFactorial(i)), 5, BigDecimal.ROUND_HALF_UP);
            // r / u 的 i 次方
            BigDecimal rDivideU = r.divide(u, 5, BigDecimal.ROUND_HALF_UP).pow(i);
            // oneDivideI * rDivideU
            BigDecimal oneDivideI_rDivideU = oneDivideI.multiply(rDivideU);
            // sum = sum + oneDivideI_rDivideU
            sum = sum.add(oneDivideI_rDivideU);
        }
        return sum;
    }

    /**
     * 获取k的阶乘
     */
    public static long gteFactorial(int k) {
        if (k == 0 || k == 1) {
            return 1;
        }
        long factorial = 1;
        for (int i = 2; i <= k; i++) {
            factorial *= i;
        }
        return factorial;
    }


    private static BigDecimal getR(List<TimeData> timeDataList) {
        // 求取timeInterval 的平均值  stream实现 保留5位小数
        List<BigDecimal> timeIntervalList = timeDataList.stream().map(TimeData::getTimeInterval).collect(Collectors.toList());
        BigDecimal timeIntervalAvg = timeIntervalList.stream().reduce(BigDecimal.ZERO, BigDecimal::add).divide(new BigDecimal(timeIntervalList.size()), 5, BigDecimal.ROUND_HALF_UP);
        // 求取r的值
        BigDecimal r = new BigDecimal(60).divide(timeIntervalAvg, 5, BigDecimal.ROUND_HALF_UP);
        return r;
    }

    private static BigDecimal getU(List<TimeData> timeDataList) {
        // 求取passTime 的平均值 stream实现
        List<BigDecimal> passTimeList = timeDataList.stream().map(TimeData::getPassTime).collect(Collectors.toList());
        BigDecimal passTimeAvg = passTimeList.stream().reduce(BigDecimal.ZERO, BigDecimal::add).divide(new BigDecimal(passTimeList.size()), 5, BigDecimal.ROUND_HALF_UP);
        // 求u的值
        BigDecimal u = new BigDecimal(60).divide(passTimeAvg, 5, BigDecimal.ROUND_HALF_UP);
        return u;
    }

}
