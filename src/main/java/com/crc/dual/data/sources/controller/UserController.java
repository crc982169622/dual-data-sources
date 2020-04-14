package com.crc.dual.data.sources.controller;

import com.crc.dual.data.sources.dao.UserDao;
import com.crc.dual.data.sources.domain.User;
import com.crc.dual.data.sources.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.Date;
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

    @Resource(name = "jtaTransactionManager")
    private JtaTransactionManager jtaTransactionManager;

    @RequestMapping("/insert")
    public void insert() {
        UserTransaction userTransaction = jtaTransactionManager.getUserTransaction();
        try {
            userTransaction.begin();
            User user = new User("111", "111", "111", "111", new Date(), 0);
            user.setId(3);
            userService.insert1(user);
            user.setId(4);
            userService.insert2(user);
            userTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                userTransaction.rollback();
            } catch (SystemException e1) {
                e1.printStackTrace();
            }
        }

    }


}
