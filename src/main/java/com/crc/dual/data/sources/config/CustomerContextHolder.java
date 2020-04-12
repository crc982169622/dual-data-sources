package com.crc.dual.data.sources.config;

/**
 * @author: chenrencun
 * @version：
 * @date: 2020/4/12 21:07
 **/
public class CustomerContextHolder {

    public static final String DATA_SOURCE_DEFAULT = "dataSource";

    public static final String DATA_SOURCE_ONE = "dataSource1";

    // 用ThreadLocal来设置当前线程使用哪个dataSource
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**设置要使用的数据源*/
    public static void setCustomerType(String customerType) {
        contextHolder.set(customerType);
    }

    /**获取数据源*/
    public static String getCustomerType() {
        String dataSource = contextHolder.get();
        if (dataSource.isEmpty()) {
            return DATA_SOURCE_DEFAULT;
        } else {
            return dataSource;
        }
    }

    /**清除数据源，使用默认的数据源*/
    public static void clearCustomerType() {
        contextHolder.remove();
    }

}
