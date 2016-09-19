package org.mycommon.springboot.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mycommon.springboot.domain.User;
import org.mycommon.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by KangXinghua on 2016/9/9.
 */
@Service
public class UserService {
    private static Logger logger = LogManager.getLogger(UserService.class);
    @Autowired
    private UserMapper userMapper;

    public String getName(String name) {
        User user = userMapper.findOne(name);
        List<User> userList = userMapper.findAll();
        logger.info(userList);
        logger.info(user);
        return name;
    }
}
