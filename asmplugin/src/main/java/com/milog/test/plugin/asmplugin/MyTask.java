package com.milog.test.plugin.asmplugin;

import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.Task;

import javax.inject.Inject;

import groovy.lang.Closure;

/**
 * Created by miloway on 2018/8/16.
 */

public class MyTask extends DefaultTask {

    public void print() {
        System.out.println("==================");
        System.out.println("MyTask");
        System.out.println("==================");
    }

    @Override
    public Task doLast(Action<? super Task> action) {
        System.out.println("MyTask =======" + action.toString());
        return super.doLast(action);
    }

    @Override
    public Task doLast(Closure action) {
        System.out.println("MyTask2 =======" + action.toString());
        return super.doLast(action);
    }
}
