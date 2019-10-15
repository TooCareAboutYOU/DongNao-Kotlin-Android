package com.dongnao.java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;

import com.dongnao.kotlin.R;
import com.dongnao.kotlin.h.Hello;

public class JavaActivity extends AppCompatActivity {

    AppCompatTextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        tv = findViewById(R.id.acTv_kotlin_txt);

        tv.setText(Hello.getNames()+"\n"+Hello.userSex);

    }
}
