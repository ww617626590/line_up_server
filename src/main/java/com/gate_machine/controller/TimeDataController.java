package com.gate_machine.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gate_machine.domain.TimeData;
import com.gate_machine.result.R;
import com.gate_machine.service.TimeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TimeDataController {

    @Autowired
    private TimeDataService timeDataService;

//原始数据 主页显示

@GetMapping("/DataManagement")
    public R<Page> DataManagement(int page, int pageSize) {
    //使用mybatisPlus查询所有数据并分页展示前端
    //创建page对象
    Page<TimeData> pageInfo = new Page<>(page, pageSize);
    //构建查询条件
    LambdaQueryWrapper<TimeData> queryWrapper = new LambdaQueryWrapper<>();
    //根据排序条件升序
    queryWrapper.orderByAsc(TimeData::getId);
    //查询page
     timeDataService.page(pageInfo, queryWrapper);
    return R.success(pageInfo);
}

}
