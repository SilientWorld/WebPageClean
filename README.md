该项目为“清洗网页内容并分析输入字段的安全性”
需要实现的功能：
[1]通过字符串匹配或正则表达式对原始代码进行清洗，移除网页中的<script>标签、内联样式、HTML注释等不必要或可能带有恶意代码的内容；
[2]提取网页中的用户输入字段（如<input>和<textarea>标签），并分析其属性（如type、maxlength等）是否存在安全隐患；
[3]将网页内容清洗和输入字段检测集成；
[4]有个简单直观的界面，以便展示上述功能。

1、本次大作业使用Android Studio编程环境。

2、在代码部分需要导入Jsoup库，在build.gradle.kts(Module:app)内添加：
dependencies {
    implementation("org.jsoup:jsoup:1.15.3")
    }
如果是build.gradle.java(Module:app)，则添加：
dependencies {
    implementation 'org.jsoup:jsoup:1.15.4'
}
保存更改后，点击 "Sync Now"（立即同步）按钮，Android Studio将自动下载并添加 Jsoup 库到项目中。

3、源代码见文件夹:
逻辑实现部分：\MyApplication1\app\src\main\java\com\example\myapplication1
页面设计部分：\MyApplication1\app\src\main\res\layout

ColorChange.java：实现页面颜色变换的功能。
DisablePaste.java：实现禁止粘贴的功能。
HtmlCheck.java：检查特定标签是否有必要的属性，并输出详细的安全隐患。
HtmlClean.java：实现清除恶意代码的功能。
HtmlHighLight.java：高亮存在恶意的代码以及可能存在安全隐患的代码。
HtmlJudge.java：判断输入的代码是否为HTML代码。
HtmlProcessor.java：三个文本框之间的逻辑交互功能。
MainActivity.java：主函数代码。
main_activity.xml：页面设计的代码。
