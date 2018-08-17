package com.milog.test.myasmtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.milog.test.myasmtest.annotation.FunctionManager;

import org.objectweb.asm.ClassWriter;

public class MainActivity extends Activity {

    @FunctionManager("function_state")
    private String state;

    private TextView tvShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvShow = findViewById(R.id.tvShow);
        init();
    }

    private void init() {
//        ClassWriter
    }
}
