package com.milog.test.plugin.asmplugin.task;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

/**
 * Created by miloway on 2018/8/29.
 */

public class ASMTask extends DefaultTask {

    public static final String TASK_DEBUG_JAVA_RES = "processDebugJavaRes";
    public static final String TASK_RELEASE_JAVA_RES = "processReleaseJavaRes";

    @TaskAction
    public void processOnClick() {
        System.out.println("processOnClick");
    }
}
