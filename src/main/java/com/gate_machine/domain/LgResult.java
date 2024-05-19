package com.gate_machine.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * 时间存储
 * @TableName lg_result
 */
@TableName(value ="lg_result")
@Data
public class LgResult implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * u
     */
    private BigDecimal u;

    /**
     * r
     */
    private BigDecimal r;

    /**
     * p
     */
    private BigDecimal p;

    /**
     * 平均队长
     */
    private BigDecimal l;

    /**
     * 平均等待对长
     */
    private BigDecimal lq;

    /**
     * 平均逗留时间
     */
    private BigDecimal w;

    /**
     * 平均等待时间
     */
    private BigDecimal wq;

    /**
     * 算法
     */
    private String sf;
    private BigDecimal p0;
    private Date createTime;

    /**
     * 排队数据格式（0：检票闸机数据）（1：安检设施数据）（2：自动售票机数据）
     */
    private String type;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LgResult other = (LgResult) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getU() == null ? other.getU() == null : this.getU().equals(other.getU()))
            && (this.getR() == null ? other.getR() == null : this.getR().equals(other.getR()))
            && (this.getP() == null ? other.getP() == null : this.getP().equals(other.getP()))
            && (this.getL() == null ? other.getL() == null : this.getL().equals(other.getL()))
            && (this.getLq() == null ? other.getLq() == null : this.getLq().equals(other.getLq()))
            && (this.getW() == null ? other.getW() == null : this.getW().equals(other.getW()))
            && (this.getWq() == null ? other.getWq() == null : this.getWq().equals(other.getWq()))
            && (this.getSf() == null ? other.getSf() == null : this.getSf().equals(other.getSf()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getU() == null) ? 0 : getU().hashCode());
        result = prime * result + ((getR() == null) ? 0 : getR().hashCode());
        result = prime * result + ((getP() == null) ? 0 : getP().hashCode());
        result = prime * result + ((getL() == null) ? 0 : getL().hashCode());
        result = prime * result + ((getLq() == null) ? 0 : getLq().hashCode());
        result = prime * result + ((getW() == null) ? 0 : getW().hashCode());
        result = prime * result + ((getWq() == null) ? 0 : getWq().hashCode());
        result = prime * result + ((getSf() == null) ? 0 : getSf().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", u=").append(u);
        sb.append(", r=").append(r);
        sb.append(", p=").append(p);
        sb.append(", l=").append(l);
        sb.append(", lq=").append(lq);
        sb.append(", w=").append(w);
        sb.append(", wq=").append(wq);
        sb.append(", sf=").append(sf);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}