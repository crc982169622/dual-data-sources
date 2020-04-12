package com.crc.dual.data.sources.dao;

import com.crc.dual.data.sources.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: chenrencun
 * @version：
 * @date: 2020/4/12 16:34
 **/
@Repository
public interface UserDao {

    List<User> getList();
}
