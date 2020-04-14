package com.crc.dual.data.sources.service;

import com.crc.dual.data.sources.domain.User;

import java.util.List;

/**
 * @author: chenrencun
 * @version：
 * @date: 2020/4/12 21:16
 **/
public interface UserService {

    List<User> getList();

    List<User> getList1();

    void insert1(User user);

    void insert2(User user);

    void update1(User user);

    void update2(User user);


}
