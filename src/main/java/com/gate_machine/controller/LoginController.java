package com.gate_machine.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gate_machine.domain.User;
import com.gate_machine.handle.AlgorithmHandle;
import com.gate_machine.result.R;
import com.gate_machine.result.bizResult.CalculateResult;
import com.gate_machine.result.tips.SuccessTip;
import com.gate_machine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    AlgorithmHandle algorithmHandle;
    @Autowired
    UserService userService;

    /**
     * 这是个登录接口122
     */
    @PostMapping("/login")
    public R<String> login(@RequestBody User user, HttpServletRequest request) {
        //根据页面的数据查询数据库
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName, user.getUserName());
        User userServiceOne = userService.getOne(wrapper);
        //如果没有查询到 返回失败1
        if (userServiceOne == null) {
            return R.error("用户名错误或注册");
        }
        //密码比对 如果密码不一致则返回密码错误
        if (!user.getPassword().equals(userServiceOne.getPassword())) {
            return R.error("密码错误");
        }


        //登录成功 并把用户id保存到Session
        request.getSession().setAttribute("user", user.getId());

        return R.success("用户登录成功");
    }

    /**
     * 这是一个注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public R<String> register(@RequestBody User user) {
        if (user.getUserName() == null || user.getPassword() == null) {
            return R.error("用户名或密码不能为空");
        }
        if (userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUserName, user.getUserName())) != null) {
            return R.error("用户名已存在");
        }
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, user.getUserName());
        //把user添加到数据库
        boolean save = userService.save(user);
        R.error("注册成功");

        return R.success("注册成功");
    }



    @GetMapping("/test")
    public Object passTime() {
        return new SuccessTip();
    }

    /**
     * 获取平均时间的接口
     */
    @GetMapping("/passTime")
    public Object passTime(String type) {
        CalculateResult result = algorithmHandle.mM1(type);
        return new SuccessTip().data(result);
    }
}
