package com.gate_machine.service;

import com.gate_machine.domain.TimeData;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author wanghao
* @description 针对表【time_data】的数据库操作Service
* @createDate 2024-05-15 15:46:16
*/
public interface TimeDataService extends IService<TimeData> {

    List<TimeData> selectByType(String type);
}
