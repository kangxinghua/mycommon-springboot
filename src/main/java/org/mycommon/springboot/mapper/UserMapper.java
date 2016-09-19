package org.mycommon.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mycommon.springboot.domain.User;

import java.util.List;

@Mapper
public interface UserMapper extends UserMapperGen {

    /**
     * findOne
     *
     * @param userName
     * @return
     */
    @Select(value = "select * from sys_user where userName=#{userName}")
    User findOne(String userName);

}
