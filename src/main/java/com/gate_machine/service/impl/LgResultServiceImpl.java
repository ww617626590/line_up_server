package com.gate_machine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gate_machine.domain.LgResult;
import com.gate_machine.service.LgResultService;
import com.gate_machine.mapper.LgResultMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author wanghao
* @description 针对表【lg_result(时间存储)】的数据库操作Service实现
* @createDate 2024-05-18 22:02:55
*/
@Service
public class LgResultServiceImpl extends ServiceImpl<LgResultMapper, LgResult>
    implements LgResultService{

    @Override
    public Page pageMain(Integer page, Integer pageSize, String suanfa, String data) {
        if (page == null){
            page = 1;
        }
        if (pageSize == null){
            pageSize = 10;
        }
        Page<LgResult> pageResult = new Page(page, pageSize);
        LambdaQueryWrapper<LgResult> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (StringUtils.isNotBlank(suanfa)) {
            lambdaQueryWrapper.like(LgResult::getSf, suanfa);
        }
        if (StringUtils.isNotBlank(data)) {
            if ("检票闸机".equals(data)) {
                lambdaQueryWrapper.like(LgResult::getType, "1");
            }
            if ("安检设施".equals(data)) {
                lambdaQueryWrapper.like(LgResult::getType, "2");
            }
            if ("自动售票机".equals(data)) {
                lambdaQueryWrapper.like(LgResult::getType, "3");
            }
        }
        lambdaQueryWrapper.orderByDesc(LgResult::getCreateTime);
        pageResult = this.page(pageResult, lambdaQueryWrapper);
        List<LgResult> records = pageResult.getRecords();
        for (LgResult record : records) {
            if ("1".equals(record.getType())) {
                record.setType("检票闸机");
            }
            if ("2".equals(record.getType())) {
                record.setType("安检设施");
            }
            if ("3".equals(record.getType())) {
                record.setType("自动售票机");
            }
        }
        return pageResult;
    }
}




