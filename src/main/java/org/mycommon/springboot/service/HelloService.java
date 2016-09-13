package org.mycommon.springboot.service;

import org.springframework.stereotype.Service;

/**
 * Created by KangXinghua on 2016/9/9.
 */
@Service
public class HelloService {
    public String getName(String name) {
        return name;
    }
}
