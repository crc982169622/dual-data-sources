package com.crc.dual.data.sources.annotation;

import com.crc.dual.data.sources.constants.DataSourceType;

import java.lang.annotation.*;

/**
 * @author: crc
 * @version:1.0
 * @date: 2020-04-13 9:15
 * @descripton:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    DataSourceType value() default DataSourceType.DATA_SOURCE_DEFAULT;
}
