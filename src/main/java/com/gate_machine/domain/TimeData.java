package com.gate_machine.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * 
 * @TableName time_data
 */
@TableName(value ="time_data")
@Data
public class TimeData implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Integer id;

    /**
     * 通过时间
     */
    private BigDecimal passTime;

    /**
     * 时间间隔
     */
    private BigDecimal timeInterval;

    /**
     * 排队方式
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
        TimeData other = (TimeData) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPassTime() == null ? other.getPassTime() == null : this.getPassTime().equals(other.getPassTime()))
            && (this.getTimeInterval() == null ? other.getTimeInterval() == null : this.getTimeInterval().equals(other.getTimeInterval()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPassTime() == null) ? 0 : getPassTime().hashCode());
        result = prime * result + ((getTimeInterval() == null) ? 0 : getTimeInterval().hashCode());
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
        sb.append(", passTime=").append(passTime);
        sb.append(", timeInterval=").append(timeInterval);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}