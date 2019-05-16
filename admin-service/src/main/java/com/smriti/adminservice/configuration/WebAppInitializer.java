package com.smriti.adminservice.configuration;

import com.smriti.emailservice.configuration.ApplicationConfiguration;
import com.smriti.emailservice.configuration.RootConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ApplicationConfiguration.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
