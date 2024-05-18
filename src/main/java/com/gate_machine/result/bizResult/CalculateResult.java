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

    public void setU(BigDecimal u) {
        this.u = u.setScale(3, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getU() {
        return u;
    }

    public void setR(BigDecimal r) {
        this.r = r.setScale(3, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getR() {
        return r;
    }

    public void setP(BigDecimal p) {
        this.p = p.setScale(3, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getP() {
        return p;
    }

    public void setP0(BigDecimal p0) {
        this.p0 = p0.setScale(3, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getP0() {
        return p0;
    }

    public void setL(BigDecimal L) {
        this.L = L.setScale(3, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getL() {
        return L;
    }

    public void setLq(BigDecimal Lq) {
        this.Lq = Lq.setScale(3, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getLq() {
        return Lq;
    }

    public void setW(BigDecimal W) {
        this.W = W.setScale(3, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getW() {
        return W;
    }

    public void setWq(BigDecimal Wq) {
        this.Wq = Wq.setScale(3, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getWq() {
        return Wq;
    }

}
