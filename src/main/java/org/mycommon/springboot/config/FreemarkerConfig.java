package org.mycommon.springboot.config;

import com.google.common.collect.Maps;
import freemarker.template.TemplateException;
import org.mycommon.springboot.config.freemarker.MyTagFreeMarkerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.IOException;
import java.util.Map;

/**
 * Created by KangXinghua on 2016/9/21.
 */
@Configuration
public class FreemarkerConfig {
    @Bean
    public MyTagFreeMarkerConfigurer freeMarkerConfigurer() throws IOException, TemplateException {
        MyTagFreeMarkerConfigurer freeMarkerConfigurer = new MyTagFreeMarkerConfigurer();
        freeMarkerConfigurer.setPreferFileSystemAccess(false);
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/views/");
        freeMarkerConfigurer.setDefaultEncoding("UTF-8");

        Map<String, Object> freemarkerVariables = Maps.newHashMap();
//        freemarkerVariables.put("limit", new LimitMethod());
//        freemarkerVariables.put("hasPermission", new HasPermissionDirective(molgenisPermissionService));
//        freemarkerVariables.put("notHasPermission", new NotHasPermissionDirective(molgenisPermissionService));
//        addFreemarkerVariables(freemarkerVariables);

        freeMarkerConfigurer.setFreemarkerVariables(freemarkerVariables);

        return freeMarkerConfigurer;
    }

    @Bean
    public ViewResolver viewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setViewClass(FreeMarkerView.class);
        viewResolver.setCache(false);
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".ftl");
        viewResolver.setContentType("text/html; charset=utf-8");
        viewResolver.setExposeRequestAttributes(true);
        viewResolver.setExposeSessionAttributes(true);
        viewResolver.setExposeSpringMacroHelpers(true);
        viewResolver.setRequestContextAttribute("requestContext");
        viewResolver.setOrder(1);
        return viewResolver;
    }
}
