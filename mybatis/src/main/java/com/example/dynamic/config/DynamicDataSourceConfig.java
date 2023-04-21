package com.example.dynamic.config;

import com.example.dynamic.constant.DataSourceConstants;
import com.example.dynamic.datasource.DynamicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class DynamicDataSourceConfig {

    /**
     * 主数据来源
     *
     * @return {@link DataSource}
     */
    @Bean(DataSourceConstants.MASTER)
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 从数据源
     *
     * @return {@link DataSource}
     */
    @Bean(DataSourceConstants.SLAVE)
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 动态数据来源
     *
     * @return {@link DataSource}
     */
    @Bean
    @Primary
    public DataSource dynamicDataSource() {
        Map<Object, Object> dataSources = new HashMap<>(2);
        dataSources.put(DataSourceConstants.MASTER, masterDataSource());
        dataSources.put(DataSourceConstants.SLAVE, slaveDataSource());
        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(dataSources);
        dataSource.setDefaultTargetDataSource(masterDataSource());
        return dataSource;
    }

}
