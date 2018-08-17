package com.milog.test.plugin.asmplugin;

/**
 * Created by miloway on 2018/8/16.
 */

public class MyConfig {

    public void setConfig(String config) {
        this.config = config;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void isOpen(boolean open) {
        isOpen = open;
    }

    public void setExt(MyConfigSub ext) {
        this.ext = ext;
    }

    public String getConfig() {
        return config;
    }

    public String getProjectName() {
        return projectName;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public MyConfigSub getExt() {
        return ext;
    }

    private String config;
    private String projectName;
    private boolean isOpen;
    private MyConfigSub ext;

    public MyConfig() {
        config = "";
        projectName = "";
        isOpen = false;
    }

    public MyConfig(String str) {
        config = "";
        projectName = "";
        isOpen = false;
    }

    public void aa(String aa) {
        if (ext != null) {
            ext.aa(aa);
        }
    }

    public void printProperties() {
        String str = "config" + config + "\nprojectName" + projectName + "\nisOpen" + isOpen;
        if (ext != null) {
            str += "\next" + ext.toString();
        }
        System.out.println(str);
    }
}
