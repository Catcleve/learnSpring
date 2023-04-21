package com.example.controller;

import com.example.common.CommonResult;
import com.example.dto.DataSourceConfig;
import com.example.dynamic.datasource.DynamicDataSource;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/datasource")
public class DataSourceController {

    @Resource
    private DynamicDataSource dynamicDataSource;

    @GetMapping("/all")
    public CommonResult<?> all() {

        return CommonResult.success(dynamicDataSource.getBackupDataSources().keySet(), "获取成功");
    }

    @PostMapping("/add")
    public CommonResult<?> add(@RequestBody DataSourceConfig dataSourceConfig) {
        dynamicDataSource.addDataSource(dataSourceConfig.getName(), dataSourceConfig);
        return CommonResult.success(null, "添加成功");
    }


}
