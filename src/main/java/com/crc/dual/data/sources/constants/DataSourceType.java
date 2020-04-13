package com.crc.dual.data.sources.constants;

/**
 * @author: crc
 * @version:1.0
 * @date: 2020-04-13 10:21
 * @descripton:
 */
public enum DataSourceType {

    DATA_SOURCE_DEFAULT("dataSource"),

    DATA_SOURCE_ONE("dataSource1"),
    ;

    private String value;

    public String getValue() {
        return value;
    }

    DataSourceType(String value) {
        this.value = value;
    }
}
