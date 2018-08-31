package com.milog.test.plugin.asmplugin.transform;

import java.io.File;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * Created by miloway on 2018/8/30.
 */

public class ClassFileInjectBtnClick {


    private static final String inject = "tvShow.setText(tvShow.getText() + \" inject\");";
    private static final String TAG = "ClassFileInjectBtnClick ";


    public static void inject(String path, String packageName) {
        try {
            System.out.println("transform2 inject");
            ClassPool classPool = ClassPool.getDefault();
            System.out.println("transform2 inject1");
            classPool.appendClassPath(path);
            System.out.println("transform2 inject2");
            File dir = new File(path);
            if (dir.isDirectory()) {
                File[] files = dir.listFiles();
                if (files == null) {
                    System.out.println("transform2 inject3");
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

                            //class file
                            System.out.println("transform2 inject4" + className);
                            CtClass c = classPool.getCtClass(className);
                            System.out.println("transform2 inject5" + c);
                            if (c.isFrozen()) {
                                c.defrost();
                            }

                            CtMethod[] methods = c.getDeclaredMethods("onClick");
                            if (methods != null) {
                                for (CtMethod method : methods) {
                                    System.out.println("onclick method " + method.getLongName());
                                    method.insertAfter(inject);
                                }
                            }


                            c.writeFile(path);
                            c.detach();
                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static boolean filterFile(String path) {
        System.out.println(TAG + path);
        return path.endsWith(".class")
                && !path.contains("R.class")
                && !path.contains("BuildConfig.class");
    }


}
