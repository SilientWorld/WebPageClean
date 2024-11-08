package com.example.myapplication1;

import android.text.TextUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

public class HtmlJudge {

    // 检查输入字符串是否为空
    public static boolean isHtml(String input) {
        if (TextUtils.isEmpty(input)) {
            return false;
        }
    //检查输入字符串是否包含常见的HTML标签，同时排除包含 import 或 main 关键字的情况
        if (!input.contains("<html>") && !input.contains("<body>") &&
                !input.contains("<!DOCTYPE html>") && !input.contains("<head>") ||
                input.contains("import") || input.contains("main")) {
            return false;
        }
    //使用Jsoup库解析输入字符串，检查标签内部是否有内容，无内容则该代码无效
        try {
            Document doc = Jsoup.parse(input, "", Parser.htmlParser());
            return doc.body().childrenSize() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
