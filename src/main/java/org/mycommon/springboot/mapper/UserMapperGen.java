package org.mycommon.springboot.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.mycommon.springboot.model.UserModel;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapperGen {

	//===========================================代码生成开始============================================

    UserModel getUser(String userName);

    List<UserModel> getUserList(Map<String, Object> searchParams);

    int insertUser(UserModel userModel);

    int insertUserBatch(List<UserModel> userModelList);

    int updateUser(UserModel userModel);

    //===========================================代码生成结束============================================
}
