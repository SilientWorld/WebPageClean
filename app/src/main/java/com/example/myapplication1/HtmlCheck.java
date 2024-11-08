package com.example.myapplication1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlCheck {

    // 检查 <input>、<textarea> 和 <select> 标签是否有必要的属性，并输出详细的安全隐患
    public static String checkInputAndTextareaAndSelectTags(String html) {
        Document doc = Jsoup.parse(html); // 使用 Jsoup 解析 HTML 内容
        Elements inputElements = doc.select("input"); // 获取所有 <input> 标签
        Elements textareaElements = doc.select("textarea"); // 获取所有 <textarea> 标签
        Elements selectElements = doc.select("select"); // 获取所有 <select> 标签
        StringBuilder result = new StringBuilder();

        // 检查是否存在任何输入字段
        if (inputElements.isEmpty() && textareaElements.isEmpty() && selectElements.isEmpty()) {
            return "没有检测到任何输入字段!";
        }

        // 检查 <input> 标签
        for (Element input : inputElements) {
            boolean hasType = input.hasAttr("type");
            boolean hasMaxLength = input.hasAttr("maxlength");

            // 获取 <input> 标签的 HTML 表达形式，去除换行和多余空格
            String inputTag = input.toString().replaceAll("\\s+", " ").trim();

            result.append("检测到的输入字段：").append(inputTag).append("\n");

            // 检查缺少的属性
            if (hasType && hasMaxLength) {
                result.append("代码无安全隐患").append("\n");
            } else {
                if (!hasType) {
                    result.append("安全隐患：缺少 type 属性！\n");
                }
                if (!hasMaxLength) {
                    result.append("安全隐患：缺少 maxlength 属性！\n");
                }
            }
            result.append("\n"); // 添加换行分隔每个 <input> 检查结果
        }

        // 检查 <textarea> 标签
        for (Element textarea : textareaElements) {
            boolean hasMaxLength = textarea.hasAttr("maxlength");

            // 获取 <textarea> 标签的 HTML 表达形式，去除换行和多余空格
            String textareaTag = textarea.toString().replaceAll("\\s+", " ").trim();

            result.append("检测到的输入字段：").append(textareaTag).append("\n");

            // 检查缺少的属性
            if (!hasMaxLength) {
                result.append("安全隐患：缺少 maxlength 属性！\n");
            } else {
                result.append("代码无安全隐患").append("\n");
            }
            result.append("\n"); // 添加换行分隔每个 <textarea> 检查结果
        }

        // 检查 <select> 标签
        for (Element select : selectElements) {
            boolean hasName = select.hasAttr("name");

            // 获取 <select> 标签的 HTML 表达形式，去除换行和多余空格
            String selectTag = select.toString().replaceAll("\\s+", " ").trim();

            result.append("检测到的输入字段：").append(selectTag).append("\n");

            // 检查缺少的属性
            if (!hasName) {
                result.append("安全隐患：缺少 name 属性！\n");
            } else {
                result.append("代码无安全隐患").append("\n");
            }
            result.append("\n"); // 添加换行分隔每个 <select> 检查结果
        }

        return result.toString();
    }
}
