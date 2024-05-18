package com.gate_machine.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;


import lombok.Data;


/**
* 用户表
* @TableName user
*/
@Data
public class User implements Serializable {

    /**
    * 主键
    */
    @NotNull(message="[主键]不能为空")
    private int id;
    /**
    * 用户名
    */
    @NotBlank(message="[用户名]不能为空")
    @Size(max= 20,message="编码长度不能超过20")
    private String userName;
    /**
    * 密码
    */
    @NotBlank(message="[密码]不能为空")
    @Size(max= 50,message="编码长度不能超过50")
    private String password;
    /**
    * 邮箱
    */
    @Size(max= 70,message="编码长度不能超过70")
    private String userEmail;

    /**
    * 主键
    */

}
