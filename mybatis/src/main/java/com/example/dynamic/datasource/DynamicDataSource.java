package com.example.dynamic.datasource;

import com.example.dto.DataSourceConfig;
import com.example.dynamic.context.DynamicDataSourceContextHolder;
import com.google.gson.Gson;
import lombok.Data;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;

@Data
public class DynamicDataSource extends AbstractRoutingDataSource {

    private Map<Object, Object> backupDataSources;

    @Override
    protected Object determineCurrentLookupKey(){
        return DynamicDataSourceContextHolder.getDataSourceType();
    }

    /**
     * 重写父类方法，备份当前数据源
     *
     * @param targetDataSources 目标数据源
     */
    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        this.backupDataSources = targetDataSources;
        super.setTargetDataSources(targetDataSources);
    }

    public void addDataSource(String key, DataSourceConfig config) {
        this.backupDataSources.put(key, DataSourceBuilder.create().url(config.getUrl()).username(config.getUsername()).password(config.getPassword()).build());
        super.setTargetDataSources(this.backupDataSources);
        //重新设置数据池
        super.afterPropertiesSet();
    }


    public void removeDataSource(String key) {
        this.backupDataSources.remove(key);
        super.setTargetDataSources(this.backupDataSources);
        //重新设置数据池
        super.afterPropertiesSet();
    }

    public static void main(String[] args) {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/test");
        dataSourceConfig.setUsername("XXXX");
        dataSourceConfig.setPassword("XXXX");
        Gson gson = new Gson();
        String json = gson.toJson(dataSourceConfig);
        System.out.println("json = " + json);
    }

}
