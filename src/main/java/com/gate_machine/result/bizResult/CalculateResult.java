package com.gate_machine.result.bizResult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Data

public class CalculateResult {

    /**
     * μ 用u字母代替  60 / 平均能通过时间
     */
    private BigDecimal u;
    /**
     * λ 用r字母代替  60 / 平均间隔时间
     */
    private BigDecimal r;
    /**
     * σ  r / u
     */
    private BigDecimal p;
    /**
     * p0
     */
    private BigDecimal p0;
    /**
     * 平均队长L
     */
    private BigDecimal L;

    /**
     * 平均等待堆场Lq
     */
    private BigDecimal Lq;

    /**
     * 平均逗留时间W
     */
    private BigDecimal W;
    /**
     * 平均等待时间Wa
     */
    private BigDecimal Wq;

}
