package com.gate_machine.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gate_machine.domain.TimeData;
import com.gate_machine.result.R;
import com.gate_machine.service.TimeDataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class TimeDataController {

    @Autowired
    private TimeDataService timeDataService;

//原始数据 主页显示

@GetMapping("/pageAll")
    public R<Page> DataManagement(@RequestParam Integer page, @RequestParam Integer size,@RequestParam String type) {

    //使用mybatisPlus查询所有数据并分页展示前端
    //创建page对象
    Page<TimeData> pageInfo = new Page<>(page, size);
    //构建查询条件
    LambdaQueryWrapper<TimeData> queryWrapper = new LambdaQueryWrapper<>();
    if (StringUtils.isNotBlank(type)){
        if (type.equals("1")) {
            queryWrapper.eq(TimeData::getType,type);
        }
        if (type.equals("2")){
            queryWrapper.eq(TimeData::getType,type);
        }
        if (type.equals("3")){
            queryWrapper.eq(TimeData::getType,type);
        }

    }

    //根据排序条件升序
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
    public R<String> delete( @PathVariable Integer id ,@RequestBody Object object) {
    //删除数据
    if (id == null){
        return R.error("删除失败");
    }
    timeDataService.removeById(id);
    return R.success("删除成功");
}




}
