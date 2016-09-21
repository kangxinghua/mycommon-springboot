package org.mycommon.springboot.service;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mycommon.springboot.model.UserModel;
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
    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;

    @Autowired
    private UserMapper userMapper;

    public List<String> findPermissionUrl(String userName) {
        List<String> urls = Lists.newArrayList();
        urls.add("/");
        return urls;
    }

    public List<String> findPermissions(String username) {
        return null;
    }

    public UserModel getUser(String userName) {
        return userMapper.getUser(userName);
    }
}
