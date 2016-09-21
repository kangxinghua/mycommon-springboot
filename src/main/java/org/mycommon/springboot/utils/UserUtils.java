package org.mycommon.springboot.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.mycommon.modules.utils.Strings;
import org.mycommon.springboot.model.DataModel;
import org.mycommon.springboot.model.IdModel;
import org.mycommon.springboot.model.UserModel;
import org.mycommon.springboot.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by KangXinghua on 2014/12/1.
 */
public class UserUtils {

    private static UserService userService = SpringContextHolder.getBean(UserService.class);

    /**
     * 取出Shiro中的当前用户UserName.
     */
    public static String getCurrentUserName() {
        String userName = (String) SecurityUtils.getSubject().getPrincipal();
        if (userName != null) {
            return userName;
        } else {
            return null;
        }

    }

    public static UserModel getUser() {
        UserModel userModel = null;//(User)getCache(CACHE_USER);
        if (userModel == null) {
            try {
                String userName = (String) SecurityUtils.getSubject().getPrincipal();
                if (userName != null) {
                    userModel = userService.getUser(userName);
                }
            } catch (UnavailableSecurityManagerException e) {

            } catch (InvalidSessionException e) {

            }
        }

        if (userModel == null) {
            userModel = new UserModel();
            try {
                SecurityUtils.getSubject().logout();
            } catch (UnavailableSecurityManagerException e) {

            } catch (InvalidSessionException e) {

            }
        }

        return userModel;
    }

//    public static List<String> getUserRoleIdList() {
//        String userName = getCurrentUserName();
//        return userService.getUserRoleId(userName);
//    }

//    public static List<String> getPermissionList() {
//        return userService.getPermission(getCurrentUserName());
//    }

    public static void setInsertUser(DataModel model) {
        UserModel userModel = UserUtils.getUser();
        if (Strings.isBlank(model.getCreateBy())) {
            if (Strings.isNotBlank(userModel.getUserName())) {
                model.setCreateBy(userModel.getUserName());
                model.setCreateByName(userModel.getRealName());
            } else if (Strings.isBlank(userModel.getUserName())) {
                model.setCreateBy("admin");
                model.setCreateByName("admin");
            }
        }
        if (null == model.getCreateTime()) {
            model.setCreateTime(new Date());
        }
        if (null == model.getDeleted()) {
            model.setDeleted(false);
        }

        model.setUpdateBy(model.getCreateBy());
        model.setUpdateByName(model.getCreateByName());
        model.setUpdateTime(model.getCreateTime());
        setInsertUser((IdModel) model);
    }

    public static void setInsertUser(IdModel model) {
        if (Strings.isBlank(model.getId())) {
            model.setId(UUID.randomUUID().toString());
        }
    }

    public static void setUpdateUser(DataModel model) {
        UserModel userModel = UserUtils.getUser();
        if (Strings.isNotBlank(userModel.getUserName())) {
            model.setUpdateBy(userModel.getUserName());
            model.setUpdateByName(userModel.getRealName());
        } else if (Strings.isBlank(userModel.getUserName())) {
            model.setUpdateBy("admin");
            model.setUpdateByName("admin");
        }

        model.setUpdateTime(new Date());
    }
}
