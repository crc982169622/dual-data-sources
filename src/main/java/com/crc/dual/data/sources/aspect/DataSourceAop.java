package com.crc.dual.data.sources.aspect;

import com.crc.dual.data.sources.annotation.DataSource;
import com.crc.dual.data.sources.config.CustomerContextHolder;
import com.crc.dual.data.sources.constants.DataSourceType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author: crc
 * @version:1.0
 * @date: 2020-04-13 9:30
 * @descripton:
 */
@Component
@Aspect
public class DataSourceAop {

    @Before("@annotation(com.crc.dual.data.sources.annotation.DataSource)")
    public void dataSwitch(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        DataSource data = null;
        if (method != null) {
            data = method.getAnnotation(DataSource.class);
        }
        String dataSource = null;
        if (data != null && data.value() != null) {
            dataSource = data.value().getValue();
        } else {
            dataSource = DataSourceType.DATA_SOURCE_DEFAULT.getValue();
        }
        CustomerContextHolder.setCustomerType(dataSource);


    }

    @After("@annotation(com.crc.dual.data.sources.annotation.DataSource)")
    public void clearDataSource(JoinPoint joinPoint) {
        CustomerContextHolder.clearCustomerType();
    }


}
