package com.milog.test.plugin.asmplugin.transform;

import com.android.build.api.transform.DirectoryInput;
import com.android.build.api.transform.Format;
import com.android.build.api.transform.JarInput;
import com.android.build.api.transform.QualifiedContent;
import com.android.build.api.transform.Transform;
import com.android.build.api.transform.TransformException;
import com.android.build.api.transform.TransformInput;
import com.android.build.api.transform.TransformInvocation;
import com.android.build.api.transform.TransformOutputProvider;
import com.android.build.gradle.internal.pipeline.TransformManager;
import com.android.utils.FileUtils;

import org.apache.commons.codec.digest.DigestUtils;
import org.gradle.api.Project;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;

/**
 * Created by miloway on 2018/8/30.
 */

public class ClassFileTransform extends Transform {

    private Project project;

    public ClassFileTransform(Project project) {
        this.project = project;
    }

    @Override
    public String getName() {
        return "miTrans";
    }

    @Override
    public Set<QualifiedContent.ContentType> getInputTypes() {
        return TransformManager.CONTENT_CLASS;
    }

    @Override
    public Set<? super QualifiedContent.Scope> getScopes() {
        return TransformManager.SCOPE_FULL_PROJECT;
    }

    @Override
    public boolean isIncremental() {
        return false;
    }

    @Override
    public void transform(TransformInvocation transformInvocation) throws TransformException, InterruptedException, IOException {
        super.transform(transformInvocation);
        System.out.println("here transform2");

        Collection<TransformInput> inputs =  transformInvocation.getInputs();
        TransformOutputProvider outputProvider = transformInvocation.getOutputProvider();
        for (TransformInput input : inputs) {
            Collection<DirectoryInput> directoryInputs = input.getDirectoryInputs();
            for (DirectoryInput directoryInput : directoryInputs) {

                //注入代码
//                MyInjects.inject(directoryInput.file.absolutePath, mProject)
                File outPut = outputProvider.getContentLocation(directoryInput.getName(), directoryInput.getContentTypes(), directoryInput.getScopes(),
                        Format.DIRECTORY);
                FileUtils.copyDirectory(directoryInput.getFile(), outPut);

            }

            //each jar
            Collection<JarInput> jarInputs = input.getJarInputs();
            for (JarInput jarInput : jarInputs) {
                String jarName = jarInput.getName();

                String md5Name = DigestUtils.md5Hex(jarInput.getFile().getAbsolutePath());
                if (jarName.endsWith(".jar")) {
                    jarName = jarName.substring(0, jarName.length() - 4);
                }

                File outPut = outputProvider.getContentLocation(jarName + md5Name, jarInput.getContentTypes(), jarInput.getScopes(), Format.JAR);
                System.out.println("jar output " + jarName);
                System.out.println("jar output " + outPut.getName());
                if (!outPut.exists()) {
                    outPut.mkdirs();
                    outPut.createNewFile();
                }
                FileUtils.copyFile(jarInput.getFile(), outPut);
            }
        }

    }
}
