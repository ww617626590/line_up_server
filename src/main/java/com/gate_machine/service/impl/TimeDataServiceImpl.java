package com.gate_machine.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gate_machine.domain.TimeData;
import com.gate_machine.service.TimeDataService;
import com.gate_machine.mapper.TimeDataMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author wanghao
* @description 针对表【time_data】的数据库操作Service实现
* @createDate 2024-05-15 15:46:16
*/
@Service
public class TimeDataServiceImpl extends ServiceImpl<TimeDataMapper, TimeData>
    implements TimeDataService{

    @Override
    public List<TimeData> selectByType(String type) {
        return this.lambdaQuery().eq(TimeData::getType, type).list();
    }
}




