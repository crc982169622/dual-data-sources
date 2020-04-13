package com.crc.dual.data.sources.config;

import com.crc.dual.data.sources.annotation.DataSource;
import com.crc.dual.data.sources.constants.DataSourceType;
import org.springframework.util.StringUtils;

/**
 * @author: chenrencun
 * @version：
 * @date: 2020/4/12 21:07
 **/
public class CustomerContextHolder {

    // 用ThreadLocal来设置当前线程使用哪个dataSource
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**设置要使用的数据源*/
    public static void setCustomerType(String customerType) {
        contextHolder.set(customerType);
    }

    /**获取数据源*/
    public static String getCustomerType() {
        String dataSource = contextHolder.get();
        if (StringUtils.isEmpty(dataSource)) {
            return DataSourceType.DATA_SOURCE_DEFAULT.getValue();
        } else {
            return dataSource;
        }
    }

    /**清除数据源，使用默认的数据源*/
    public static void clearCustomerType() {
        contextHolder.remove();
    }

}
