
---

# 清洗网页内容并分析输入字段的安全性

## 项目简介

该项目旨在通过字符串匹配或正则表达式实现网页内容的清洗，并对网页中的输入字段进行安全性分析。项目的核心功能包括：

1. **清洗网页内容**：通过字符串匹配或正则表达式清除网页中的 `<script>` 标签、内联样式、HTML 注释等可能包含恶意代码的内容。
2. **输入字段安全性分析**：提取网页中的用户输入字段（如 `<textarea>` 标签），分析其属性（如 `type`、`maxlength` 等）是否存在潜在的安全隐患。
3. **集成清洗与分析功能**：将网页清洗与输入字段安全性分析结合，提供一个综合性的功能模块。
4. **简单直观的界面**：提供一个简洁易用的界面，用户可以通过该界面执行清洗与分析操作。

## 功能需求

- **清洗功能**：使用 Jsoup 库对 HTML 内容进行处理，移除潜在的恶意内容。
- **输入字段分析**：检测输入字段的属性（如 `maxlength`、`type`）并评估安全性。
- **集成功能**：将清洗和分析功能集成在一个应用中，方便用户操作。
- **图形界面**：设计一个简洁的用户界面，使得用户能够轻松地清洗网页内容并分析输入字段的安全性。

## 技术要求

1. **编程环境**：使用 Android Studio 进行开发。
2. **安卓模拟器**：建议使用平板模拟器进行测试。
3. **外部库**：需要导入 Jsoup 库，以便进行 HTML 内容的清洗和分析。
   - 在 `build.gradle.kts` (Module:app) 中添加：
     ```kotlin
     dependencies {
         implementation("org.jsoup:jsoup:1.15.3")
     }
     ```
   - 如果使用 `build.gradle` (Module:app)，则添加：
     ```groovy
     dependencies {
         implementation 'org.jsoup:jsoup:1.15.4'
     }
     ```
   - 保存更改并点击 "Sync Now"（立即同步）按钮，Android Studio 将自动下载并集成 Jsoup 库。

## 文件结构

- **逻辑实现部分**：`\MyApplication1\app\src\main\java\com\example\myapplication1`
- **页面设计部分**：`\MyApplication1\app\src\main\res\layout`

### 主要类与功能

- **ColorChange.java**：实现页面颜色变换功能。
- **DisablePaste.java**：禁止粘贴功能。
- **HtmlCheck.java**：检查特定标签是否具有必要的属性，并输出潜在的安全隐患。
- **HtmlClean.java**：清除 HTML 页面中的恶意代码。
- **HtmlHighLight.java**：高亮显示恶意代码或可能带有安全隐患的代码。
- **HtmlJudge.java**：判断输入的代码是否为 HTML 格式。
- **HtmlProcessor.java**：处理三个文本框之间的逻辑交互功能。
- **MainActivity.java**：应用的主活动文件，负责启动应用和展示界面。
- **main_activity.xml**：应用主界面的布局文件，设计了应用的用户界面。

## 如何运行

1. **打开项目**：将项目导入到 Android Studio 中。
2. **同步 Gradle**：确保已经按照要求在 `build.gradle` 文件中添加了 Jsoup 库依赖并同步项目。
3. **选择模拟器**：选择平板模拟器进行测试。
4. **运行应用**：点击运行按钮，启动应用并进行网页内容的清洗与安全分析操作。

## 示例

- 在应用中，用户可以输入 HTML 代码，点击“清洗”按钮来移除不安全的内容（如 `<script>` 标签、内联样式等）。
- 用户也可以选择对某些输入字段进行安全性分析，查看是否存在潜在的安全隐患。

## 开发与贡献

如果您对该项目有兴趣或想要贡献，请参考以下步骤：

1. Fork 本项目到您的 GitHub 账户。
2. 克隆到本地环境进行开发。
3. 提交 Pull Request，说明您所做的改动。
