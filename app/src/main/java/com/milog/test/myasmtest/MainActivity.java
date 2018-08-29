package com.milog.test.myasmtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.milog.test.myasmtest.annotation.FunctionManager;

import org.objectweb.asm.ClassWriter;

public class MainActivity extends Activity {

    @FunctionManager("function_state")
    private String state;

    private TextView tvShow;
    private Button btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        tvShow = findViewById(R.id.tvShow);
        btnOk = findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvShow.setText("btn click");
            }
        });
    }
}
