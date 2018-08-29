package com.milog.test.plugin.asmplugin;

import org.gradle.api.Project;
import org.gradle.api.ProjectEvaluationListener;
import org.gradle.api.ProjectState;

/**
 * Created by miloway on 2018/8/29.
 */

public class ProjectListener implements ProjectEvaluationListener {

    private Project project;

    public ProjectListener(Project project) {
        this.project = project;
    }

    @Override
    public void beforeEvaluate(Project project) {
        System.out.println("beforeEvaluate " + project.getDisplayName());
    }

    @Override
    public void afterEvaluate(Project project, ProjectState state) {
        System.out.println("afterEvaluate " + project.getDisplayName() + " state" + state.getFailure());
        if (project == this.project && state.getFailure() == null) {
            System.out.println("after do something");
        }
    }
}
