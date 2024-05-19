package com.gate_machine.domain;

import lombok.Data;

import java.io.Serializable;
//封
@Data
public class DataObj implements Serializable {

    private Integer page;
    private Integer size;
    private String type;
    private String label;
    private Integer start;
    private Integer end;

}
