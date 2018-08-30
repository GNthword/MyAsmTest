package com.milog.test.plugin.asmplugin.transform;

import java.io.File;
import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

/**
 * Created by miloway on 2018/8/30.
 */

public class ClassFileInjectBtnClick {


    private final String inject = "inject";
    private ClassPool classPool;
    private final String TAG = "ClassFileInjectBtnClick ";

    public ClassFileInjectBtnClick() {
        classPool = ClassPool.getDefault();
    }

    public void inject(String path, String packageName) {
        try {
            classPool.appendClassPath(path);
            File dir = new File(path);
            if (dir.isDirectory()) {
                File[] files = dir.listFiles();
                if (files == null) {
                    return;
                }

                for (File file : files) {
                    String filePath = file.getPath();
                    if (filterFile(filePath)) {
                        int index = filePath.indexOf(packageName);
                        boolean isMyPackage = index != -1;
                        if (isMyPackage) {
                            int end = filePath.length() - 6; // .class = 6
                            String className = filePath.substring(index, end)
                                    .replace('\\', '.').replace('/', '.');

                            //开始修改class文件
                            CtClass c = classPool.getCtClass(className);

                            if (c.isFrozen()) {
                                c.defrost();
                            }


                            c.writeFile(path);
                            c.detach();
                        }
                    }
                }

            }
        } catch (NotFoundException | CannotCompileException | IOException e) {
            e.printStackTrace();
        }

    }

    private boolean filterFile(String path) {
        System.out.println(TAG + path);
        return path.endsWith(".class")
                && !path.contains("R.class")
                && !path.contains("BuildConfig.class");
    }


}
