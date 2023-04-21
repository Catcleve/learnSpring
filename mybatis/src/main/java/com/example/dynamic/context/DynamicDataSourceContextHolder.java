package com.example.dynamic.context;

import com.example.dynamic.constant.DataSourceConstants;
import org.springframework.util.StringUtils;

public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    public static void setDataSourceType(String dataSourceType) {
        CONTEXT_HOLDER.set(dataSourceType);
    }

    public static String getDataSourceType() {
        return CONTEXT_HOLDER.get() == null ? DataSourceConstants.MASTER : CONTEXT_HOLDER.get();
    }

    public static void clearDataSourceType() {
        CONTEXT_HOLDER.remove();
    }


}
