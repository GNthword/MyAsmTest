package com.milog.test.plugin.asmplugin;

import com.android.build.gradle.AppExtension;
import com.milog.test.plugin.asmplugin.config.MyConfig;
import com.milog.test.plugin.asmplugin.task.ASMTask;
import com.milog.test.plugin.asmplugin.task.MyTask;
import com.milog.test.plugin.asmplugin.transform.ClassFileTransform;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;

import java.util.ArrayList;
import java.util.Set;

public class MyPlugin implements Plugin<Project>{
    private MyConfig config;
    private ASMTask asmTask;
    @Override
    public void apply(Project project) {


        config = project.getExtensions().create("milog", MyConfig.class);
        config.printProperties();

        System.out.println("end===================");


        MyTask task = project.getTasks().create("miTask", MyTask.class);

        task.doLast(new Action<Task>() {
            @Override
            public void execute(Task task) {
                System.out.println("task doLast===================" + (task instanceof com.milog.test.plugin.asmplugin.task.MyTask));
                config.printProperties();
            }
        });

//        project.getGradle().addProjectEvaluationListener(new ProjectListener(project));

//        configASMTask(project);
        transform(project);
    }

    private void transform(Project project) {
        ClassFileTransform classFileTransform = new ClassFileTransform(project);
        AppExtension appExtension = project.getExtensions().findByType(AppExtension.class);
        appExtension.registerTransform(classFileTransform);
    }

    private void configASMTask(Project project) {

        asmTask = project.getTasks().create("asmTask", ASMTask.class);
        project.afterEvaluate(new Action<Project>() {
            @Override
            public void execute(Project project) {
                System.out.println("project.afterEvaluate===================" + project.getDisplayName());
                ArrayList<Task> list = new ArrayList<Task>(1);
                list.add(asmTask);
                Set<Task> tasks = project.getAllTasks(false).get(project);
                for (Task task1 : tasks) {
                    String taskName = task1.getName();
                    if (taskName.equals(ASMTask.TASK_DEBUG_JAVA_RES)
                            || taskName.equals(ASMTask.TASK_RELEASE_JAVA_RES)) {
                        System.out.println("task list " + task1.getName());

                        task1.setDependsOn(list);
                    }
                }

            }
        });

    }


}
