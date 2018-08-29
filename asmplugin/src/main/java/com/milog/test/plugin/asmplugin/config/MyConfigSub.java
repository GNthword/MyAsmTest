package com.milog.test.plugin.asmplugin.config;

import org.gradle.api.plugins.ExtraPropertiesExtension;

import java.util.Map;

/**
 * Created by miloway on 2018/8/17.
 */

public class MyConfigSub implements ExtraPropertiesExtension {


    public String aa;

    public MyConfigSub() {
        aa = "aa";
    }

    @Override
    public boolean has(String name) {
        return false;
    }

    @Override
    public Object get(String name) throws UnknownPropertyException {
        return null;
    }

    @Override
    public void set(String name, Object value) {

    }

    @Override
    public Map<String, Object> getProperties() {
        return null;
    }
}
