package org.mycommon.springboot.config.freemarker;

import freemarker.template.TemplateException;
import org.mycommon.springboot.config.freemarker.directive.BlockDirective;
import org.mycommon.springboot.config.freemarker.directive.ExtendsDirective;
import org.mycommon.springboot.config.freemarker.directive.OverrideDirective;
import org.mycommon.springboot.config.freemarker.directive.SuperDirective;
import org.mycommon.springboot.config.freemarker.tags.ShiroTags;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;

/**
 * Created by KangXinghua on 2014/12/1.
 */
public class MyTagFreeMarkerConfigurer extends FreeMarkerConfigurer {
    @Override
    public void afterPropertiesSet() throws IOException, TemplateException {
        super.afterPropertiesSet();
        this.getConfiguration().setSharedVariable("shiro", new ShiroTags(this.getConfiguration().getObjectWrapper()));
        this.getConfiguration().setSharedVariable("block", new BlockDirective());
        this.getConfiguration().setSharedVariable("override", new OverrideDirective());
        this.getConfiguration().setSharedVariable("extends", new ExtendsDirective());
        this.getConfiguration().setSharedVariable("super", new SuperDirective());
    }
}
