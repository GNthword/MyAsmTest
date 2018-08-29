package com.milog.test.plugin.asmplugin;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.internal.tasks.TaskExecuter;

public class MyPlugin implements Plugin<Project>{
    private MyConfig config;
    private MyConfig2 config2;
    @Override
    public void apply(Project project) {


        config = project.getExtensions().create("milog",MyConfig.class);
        config.printProperties();

        System.out.println("end===================");


        config2 = project.getExtensions().create("milog2",MyConfig2.class);
        System.out.println(config2.config);
        MyTask task = project.getTasks().create("miTask", MyTask.class);

        task.doLast(new Action<Task>() {
            @Override
            public void execute(Task task) {
                System.out.println("task doLast===================" + (task instanceof MyTask));
                config.printProperties();
                System.out.println(config2.config);
            }
        });

        project.afterEvaluate(new Action<Project>() {
            @Override
            public void execute(Project project) {
                System.out.println("project.afterEvaluate===================" + project.getDisplayName());
                config.printProperties();
                System.out.println(config2.config);
            }
        });
        project.getGradle().addProjectEvaluationListener(new ProjectListener(project));

    }


}
