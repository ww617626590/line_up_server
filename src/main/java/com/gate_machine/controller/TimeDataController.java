package com.gate_machine.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gate_machine.domain.DataObj;
import com.gate_machine.domain.TimeData;
import com.gate_machine.result.R;
import com.gate_machine.service.TimeDataService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class TimeDataController {

    @Autowired
    private TimeDataService timeDataService;

//原始数据 主页显示

@PostMapping("/pageAll")
    public R<Page> DataManagement(@RequestBody DataObj obj) {

    //使用mybatisPlus查询所有数据并分页展示前端22
    //创建page对象

    Page<TimeData> pageInfo = new Page<>(obj.getPage(), obj.getSize());
    //构建查询条件
    LambdaQueryWrapper<TimeData> queryWrapper = new LambdaQueryWrapper<>();
    if (StringUtils.isNotBlank(obj.getType())) {
        if (obj.getType().equals("1")) {
            queryWrapper.eq(TimeData::getType, obj.getType());
        }
        if (obj.getType().equals("2")) {
            queryWrapper.eq(TimeData::getType, obj.getType());
        }
        if (obj.getType().equals("3")) {
            queryWrapper.eq(TimeData::getType, obj.getType());
        }
    }
    if (StringUtils.isNotBlank(obj.getLabel())){
         //根据obj.getLabel()查询并且范围为satrt-end
        if (obj.getLabel().equals("通过时间")){
            queryWrapper.between(TimeData::getPassTime, obj.getStart(), obj.getEnd());
        }
        if (obj.getLabel().equals("时间间隔")){
            queryWrapper.between(TimeData::getTimeInterval, obj.getStart(), obj.getEnd());
        }
    }

    //根据排序条件升序111
    queryWrapper.orderByAsc(TimeData::getId);
    //查询page
     timeDataService.page(pageInfo, queryWrapper);
    return R.success(pageInfo);
}

    /**
     *  添加数据
     * @param timeData
     * @return
     */
    @PostMapping("/add")
    public R<String> add(@RequestBody TimeData timeData) {
    //添加数据
        if (timeData == null){
            return R.error("添加失败");
        }
    timeDataService.save(timeData);
    return R.success("添加成功");
}

/**
 * 根据id修改数据
 */
@PostMapping("/update")
    public R<String> update(@RequestBody TimeData timeData) {
    //修改数据
    if (timeData == null){
        return R.error("修改失败");
    }
    timeDataService.updateById(timeData);
    return R.success("修改成功");
}

/**
 * 根据id删除数据111
 */

@DeleteMapping("/delete/{id}")
    public R<String> delete( @PathVariable Integer id ) {
    //删除数据
    if (id == null){
        return R.error("删除失败");
    }
    timeDataService.removeById(id);
    return R.success("删除成功");
}

//根据id查询数据

    @GetMapping("/selectById/{id}")
    public R<TimeData> selectById(@PathVariable Integer id) {
        TimeData timeData = timeDataService.getById(id);
        if (timeData == null){
            return R.error("查询失败");
        }
        log.info("查询成功"+timeData.toString());
        return R.success(timeData);
    }


}
