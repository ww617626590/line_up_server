package com.gate_machine.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gate_machine.domain.LgResult;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author wanghao
* @description 针对表【lg_result(时间存储)】的数据库操作Service
* @createDate 2024-05-18 22:02:55
*/
public interface LgResultService extends IService<LgResult> {

    Page pageMain(int page, int pageSize, String suanfa, String data);
}
