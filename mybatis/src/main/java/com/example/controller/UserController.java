package com.example.controller;

import com.example.common.CommonResult;
import com.example.dao.UserDao;
import com.example.dto.User;
import com.example.dynamic.context.DynamicDataSourceContextHolder;
import com.example.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private IUserService userService;

    @RequestMapping("/listAll")
    public CommonResult<?> getUser(@RequestParam String source){
        DynamicDataSourceContextHolder.setDataSourceType(source);
        List<User> all;
        try {
            all = userService.findAll();;
        }finally {
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
        return CommonResult.success(all,"查询成功");
    }

}
