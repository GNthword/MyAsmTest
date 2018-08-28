package com.milog.test.plugin.asmplugin;

/**
 * Created by miloway on 2018/8/28.
 */

public class MyConfig2 {

    public MyConfig2() {}

    public String config = "1";

    public void config(String config) {
        System.out.println("cfg2" + config);
        this.config = config;
    }
}
