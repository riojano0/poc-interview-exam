package com.montivero.poc.exam.config;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.web.context.support.StandardServletEnvironment;

import java.util.HashMap;

public class ProfilePropertiesHelper {

    public static MapPropertySource getMapPropertySource(Environment env) {
        MapPropertySource mapPropertySource = new MapPropertySource("default", new HashMap<>());
        String[] activeProfiles = env.getActiveProfiles();
        if (ArrayUtils.isNotEmpty(activeProfiles)) {
            MutablePropertySources propertySources = ((StandardServletEnvironment) env).getPropertySources();
            for (PropertySource<?> propertySource : propertySources) {
                if (isApplicationConfig(propertySource)) {
                    mapPropertySource = (MapPropertySource) propertySource;
                    break;
                }
            }
        }

        return mapPropertySource;
    }

    private static boolean isApplicationConfig(PropertySource<?> propertySource) {
        return propertySource instanceof MapPropertySource
                && StringUtils.contains(propertySource.getName(), "applicationConfig");
    }
}
