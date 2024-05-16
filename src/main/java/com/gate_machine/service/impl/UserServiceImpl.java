package com.gate_machine.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gate_machine.domain.User;
import com.gate_machine.service.UserService;
import com.gate_machine.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author wanghao
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2024-05-15 14:25:16
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




