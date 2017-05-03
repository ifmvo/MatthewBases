# MatthewBases

执行命令将项目下载到本地

```
git clone https://github.com/ifmvo/MatthewBases.git
```
为了能够快速的构建并运行项目，你可以修改文件

1. 根目录/gradle/wrapper/gradle-wrapper.properties

gradle-2.14.1-all.zip  ->  gradle-xxx.zip (改成你电脑中存在的 gradle 版本)

2. 根目录/build.gradle

classpath 'com.android.tools.build:gradle:X.X.X' (gradle 版本对应的 gradle 插件版本)

这样你就不用长时间的等待 AndroidStudio 下载其他版本的 Gradle 了。

## 详细介绍

### [Android 快速开发（一），封装一个 TopBarBaseActivity](https://blog.ifmvo.cn/2017/04/14/package-topbarbaseactivity-by-toolbar/)

