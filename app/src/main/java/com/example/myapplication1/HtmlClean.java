package com.example.myapplication1;

public class HtmlClean {

    // 清理HTML内容，删除<script>标签、<style>标签、<a>标签、<img>标签、内联样式、HTML注释及空行，保留正常换行符
    public static String cleanHtmlContent(String html) {
        // 删除<script>标签
        String withoutScript = html.replaceAll("(?s)<script.*?</script>", "");

        // 删除<style>标签
        String withoutStyleTag = withoutScript.replaceAll("(?s)<style.*?</style>", "");

        // 删除内联样式
        String withoutInlineStyle = withoutStyleTag.replaceAll("style\\s*=\\s*\"[^\"]*\"", "");

        // 删除HTML注释
        String withoutComments = withoutInlineStyle.replaceAll("<!--.*?-->", "");

        // 删除<a>标签
        String withoutAnchors = withoutComments.replaceAll("(?s)<a.*?</a>", "");

        // 删除<img>标签
        String withoutImages = withoutAnchors.replaceAll("<img[^>]*>", "");

        // 返回清理后的HTML内容
        return withoutImages.replaceAll("(?m)^\\s*$\\n", "");
    }
}
