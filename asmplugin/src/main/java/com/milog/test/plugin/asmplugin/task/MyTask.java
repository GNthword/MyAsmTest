package com.milog.test.plugin.asmplugin.task;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

/**
 * Created by miloway on 2018/8/16.
 */

public class MyTask extends DefaultTask {

    @TaskAction
    public void hello() {
        System.out.println("MyTask hello");
    }

}
