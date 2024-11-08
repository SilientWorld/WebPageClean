package com.example.myapplication1;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

public class HtmlProcessor {

    // 当点击“清洗”按钮后，执行以下代码
    public static void processHtmlContent(Button cleanButton, EditText content1, EditText content2,EditText output, Context context) {
        cleanButton.setOnClickListener(view -> {
            String inputText = content1.getText().toString().trim();//获取输入的文本，并去掉前后空白
            if (HtmlJudge.isHtml(inputText)) { // 检查第一个输入框是不是Html代码
                String cleanedHtml = HtmlClean.cleanHtmlContent(inputText); // 清理特定的代码
                content2.setText(cleanedHtml);//将清理后的代码展示在第二个框

                //高亮第一个、第二个文本框的特定代码
                content1.setText(HtmlHighLight.highlightUserInputFields(inputText));
                content2.setText(HtmlHighLight.highlightUserInputFields(cleanedHtml));

                Toast.makeText(context, "恶意代码已清理", Toast.LENGTH_SHORT).show();

                // 检查清理后的代码是否有input,textarea,select标签，并输出结果
                String validationResult = HtmlCheck.checkInputAndTextareaAndSelectTags(cleanedHtml);
                output.setText(validationResult);

            } else {
                content2.setText("");
                output.setText("");
                Toast.makeText(context, "该文本不是有效的HTML文件，请重新输入", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
