package com.milog.test.plugin.asmplugin;

import org.gradle.api.DefaultTask;

import javax.inject.Inject;

/**
 * Created by miloway on 2018/8/16.
 */

public class MyTask extends DefaultTask {

    public void print() {
        System.out.println("==================");
        System.out.println("MyTask");
        System.out.println("==================");
    }
}
