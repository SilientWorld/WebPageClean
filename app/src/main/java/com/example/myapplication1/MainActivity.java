package com.example.myapplication1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // 初始化content1, content2, output 和 cleanButton
        EditText content1 = findViewById(R.id.content1);
        EditText content2 = findViewById(R.id.content2);
        EditText output = findViewById(R.id.output);
        Button cleanButton = findViewById(R.id.cleanButton);

        // 禁用粘贴功能
        DisablePaste.disablePaste(content2);
        DisablePaste.disablePaste(output);

        // 使用HtmlProcessor处理按钮点击事件
        HtmlProcessor.processHtmlContent(cleanButton, content1, content2, output, this);

        // 开始颜色变化
        ColorChange.startColorAnimation(findViewById(R.id.backgroundColorChange));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ColorChange.stopColorAnimation(); // 停止颜色变化
    }
}
