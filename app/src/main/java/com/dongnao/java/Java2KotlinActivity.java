package com.dongnao.java;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import com.dongnao.kotlin.R;
import com.dongnao.kotlin.a.A;
import com.dongnao.kotlin.a.B;
import com.dongnao.kotlin.a.Hello;
import com.dongnao.kotlin.a.Utils;


public class Java2KotlinActivity extends AppCompatActivity {

    AppCompatTextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        tv = findViewById(R.id.acTv_kotlin_txt);

        //如果多个文件使用相同的类名给Java使用，则使用注解 @file:JvmMultifileClass
        Utils.a();
//        Utils.b();
        Hello.myTest("1");
        Hello.myTest(1);


        StringBuilder builder = new StringBuilder();
        builder.append("使用kotlin顶层属性与方法：" + Hello.getNames() + "\n" + Hello.userSex).append("\n");
        builder.append("在Java中具有与kotlin一样的可见性：" + new A("哈哈哈").names).append("\n");
        builder.append("使用kotlin伴生对象：" + A.Jvm.getId()).append("\n");
        builder.append("使用kotlin声明对象：" + B.INSTANCE.getName()).append("\n");
        tv.setText(builder);
        Hello.params();
        Hello.params("hello kotlin!");
        Hello.params("hello kotlin!", 2);

        try {
            Hello.myEx();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

}
