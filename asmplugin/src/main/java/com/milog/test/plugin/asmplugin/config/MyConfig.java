package com.milog.test.plugin.asmplugin.config;

/**
 * Created by miloway on 2018/8/16.
 *
 * use setConfig() or config()
 */

public class MyConfig {

    public void setConfig(String config) {
        System.out.println("cfg " + config);
        this.config = config;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void isOpen(boolean open) {
        isOpen = open;
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

    public String config;
    public String projectName;
    public boolean isOpen;
    public MyConfigSub ext;

    public MyConfig() {
        System.out.println("init MyConfig()");
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
        if (ext == null) {
            ext = new MyConfigSub();
        }
        ext.aa = aa;
    }

    public void printProperties() {
        String str = "config" + config + "\nprojectName" + projectName + "\nisOpen" + isOpen;
        if (ext != null) {
            str += "\next " + ext.aa;
        }
        System.out.println(str);
    }
}
