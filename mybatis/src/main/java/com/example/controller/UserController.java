package com.example.controller;

import com.example.common.CommonResult;
import com.example.dto.User;
import com.example.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private IUserService userService;

    @RequestMapping("/listAll")
    public CommonResult<?> getUser(){
        return CommonResult.success(userService.findAll(),"查询成功");
    }

}
