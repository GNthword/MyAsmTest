package com.milog.test.myasmtest;

import android.util.Log;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;

/**
 * Created by miloway on 2018/8/16.
 */

public class FunctionManagerAdapter extends ClassVisitor {

    private final String TAG = "fma";

    public FunctionManagerAdapter(int api) {
        super(api);
    }

    public FunctionManagerAdapter(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        Log.d(TAG, name);
        Log.d(TAG, descriptor);
        Log.d(TAG, String.valueOf(value ));

        return super.visitField(access, name, descriptor, signature, value);
    }
}
