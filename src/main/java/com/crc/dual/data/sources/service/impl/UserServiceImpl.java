package com.crc.dual.data.sources.service.impl;

import com.crc.dual.data.sources.config.CustomerContextHolder;
import com.crc.dual.data.sources.dao.UserDao;
import com.crc.dual.data.sources.domain.User;
import com.crc.dual.data.sources.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chenrencun
 * @version：
 * @date: 2020/4/12 21:17
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getList() {
        return userDao.getList();
    }

    @Override
    public List<User> getList1() {
        CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_ONE);
        List<User> list = userDao.getList();
        CustomerContextHolder.clearCustomerType();
        return list;
    }
}
