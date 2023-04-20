package me.mason.demo.dynamicdatasource.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.util.Date;

/**
* 用户对象 test_user
*
* @author mason
* @date 2020-01-08
*/
@Data
@TableName("user")
public class TestUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private Integer age;

    public TestUser() {
    }

}
