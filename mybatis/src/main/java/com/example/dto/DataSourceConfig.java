package com.example.dto;

import lombok.Data;

/**
 * 数据源配置
 *
 * @author maonengneng
 * @date 2023/04/21
 */
@Data
public class DataSourceConfig {

    /**
     * 名字
     */
    private String name;
    /**
     * 驱动程序类名称
     */
    private String driverClassName;
    /**
     * url
     */
    private String url;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

}
