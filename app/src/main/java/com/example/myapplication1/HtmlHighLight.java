package com.example.myapplication1;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;


public class HtmlHighLight {

    // 高亮所有 <input>, <textarea>, <select> 标签及其属性，并标蓝 <script>, <style>, <a>, <img> 标签，内联样式和注释
    public static Spannable highlightUserInputFields(String html) {
        SpannableString spannableString = new SpannableString(html); // 原始HTML作为Spannable

        // 红色高亮 <input>, <textarea>, <select> 标签
        highlightTags(spannableString, html, "<input", ">", 0xFF0000FF); // 红色
        highlightTags(spannableString, html, "<textarea", "</textarea>", 0xFF0000FF); // 红色
        highlightTags(spannableString, html, "<select", "</select>", 0xFF0000FF); // 红色

        // 蓝色高亮 <script>, <style>, <a>, <img> 标签及其内联样式、注释
        highlightTags(spannableString, html, "<script", "</script>", 0xFFFF0000); // 蓝色
        highlightTags(spannableString, html, "<style", "</style>", 0xFFFF0000); // 蓝色
        highlightTags(spannableString, html, "<a", "</a>", 0xFFFF0000); // 蓝色
        highlightTags(spannableString, html, "<img", ">", 0xFFFF0000); // 蓝色
        highlightInlineStyles(spannableString, html, 0xFFFF0000); // 标蓝内联样式
        highlightHtmlComments(spannableString, html, 0xFFFF0000); // 标蓝HTML注释

        return spannableString;
    }

    // 手动高亮指定标签及其内容
    private static void highlightTags(Spannable spannable, String originalHtml, String startTag, String endTag, int color) {
        int start = originalHtml.indexOf(startTag);
        while (start >= 0) {
            int end = originalHtml.indexOf(endTag, start) + endTag.length();
            if (end > start) {
                spannable.setSpan(new ForegroundColorSpan(color), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // 高亮
            }
            start = originalHtml.indexOf(startTag, end); // 查找下一个标签
        }
    }

    // 高亮内联样式
    private static void highlightInlineStyles(Spannable spannable, String originalHtml, int color) {
        String styleTag = "style=\"";
        int start = originalHtml.indexOf(styleTag);
        while (start >= 0) {
            int end = originalHtml.indexOf("\"", start + styleTag.length()) + 1;
            if (end > start) {
                spannable.setSpan(new ForegroundColorSpan(color), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // 高亮内联样式
            }
            start = originalHtml.indexOf(styleTag, end); // 查找下一个内联样式
        }
    }

    // 高亮HTML注释
    private static void highlightHtmlComments(Spannable spannable, String originalHtml, int color) {
        String commentStart = "<!--";
        String commentEnd = "-->";
        int start = originalHtml.indexOf(commentStart);
        while (start >= 0) {
            int end = originalHtml.indexOf(commentEnd, start) + commentEnd.length();
            if (end > start) {
                spannable.setSpan(new ForegroundColorSpan(color), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // 高亮注释
            }
            start = originalHtml.indexOf(commentStart, end); // 查找下一个注释
        }
    }
}
