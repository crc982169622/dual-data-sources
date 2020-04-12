package com.crc.dual.data.sources.controller;

import com.crc.dual.data.sources.dao.UserDao;
import com.crc.dual.data.sources.domain.User;
import com.crc.dual.data.sources.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: chenrencun
 * @version：
 * @date: 2020/4/12 16:35
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getList")
    public List<User> getList(){
        return userService.getList();
    }

    @RequestMapping("/getList1")
    public List<User> getList1(){
        return userService.getList1();
    }


}
