package org.mycommon.springboot.utils;

import com.google.common.collect.Maps;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.mycommon.modules.utils.PropertiesLoader;

import java.util.Map;

/**
 * 全局配置及常量类
 * Created by KangXinghua on 2014/12/1.
 */
public class Global {
    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = Maps.newHashMap();

    /**
     * 属性文件加载对象
     */
    private static PropertiesLoader propertiesLoader = new PropertiesLoader("application.properties");

    /**
     * 获取配置
     */
    public static String getConfig(String key) {
        String value = map.get(key);
        if (value == null) {
            value = propertiesLoader.getProperty(key);
            map.put(key, value);
        }
        return value;
    }

    public static String getDefaultErrorKeyAttributeName() {
        return FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME;
    }


    public static String getUploadPath() {
        return getConfig("uploadPath");
    }

    public static int getMaxSession() {
        return Integer.valueOf(getConfig("maxSession"));
    }

    public static String getHomePath() {
        return "/";
    }

    public static String getLoginPath() {
        return "/login";
    }

    public static String getWebFiledPath() {
        return "/fileupload/file/";
    }

    public static String getWebViewFiledPath() {
        return "/fileupload/view/";
    }
}
