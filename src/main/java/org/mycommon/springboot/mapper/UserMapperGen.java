package org.mycommon.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mycommon.springboot.domain.User;

import java.util.List;

@Mapper
public interface UserMapperGen {

    /**
     * findAll
     * @return
     */
    List<User> findAll();

}
