package com.milog.test.plugin.asmplugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class MyPlugin implements Plugin<Project>{

    @Override
    public void apply(Project project) {
        MyTask task = project.getTasks().create("my", MyTask.class);
        task.print();

        MyConfig config = project.getExtensions().create("milog",MyConfig.class);
        config.printProperties();

        System.out.println("project.exts " + project.getExtensions().toString());
        System.out.println("end===================");
    }
}
