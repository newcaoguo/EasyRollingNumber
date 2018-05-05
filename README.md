# 1. EasyRollingNumber项目介绍
 > 🍎 `EasyRollingNumber` 项目是用来轻松实现滚动数字效果的一个库。


[![](https://jitpack.io/v/newcaoguo/EasyRollingNumber.svg)](https://jitpack.io/#newcaoguo/EasyRollingNumber)

## 2. 效果展示

效果图如下所示：
![演示图](https://github.com/newcaoguo/EasyRollingNumber/blob/master/EasyRollingNumber.gif)

## 3. 使用方法：

第一步：
在你的根目录中的  build.gradle 文件中，repositories 标签下添加一下代码：

Add it in your root build.gradle at the end of repositories:


```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```

第二步：
添加依赖
 Add the dependency

```
	dependencies {
	        implementation 'com.github.newcaoguo:EasyRollingNumber:1.0'
	}

```

### 4. 使用示例


### 5. API 说明

| API 名称        | 含 义   |  默 认 值  |
| --------   | -----:  | :----:  |
| setPrefixString(String prefixString)    | 设置前缀字符串 |   空     |
| setPostfixString(String postfixString)        |   设置后缀字符串  |   空   |
| setDuration(long duration)        |    设置动画持续时间    |  2000 ms  |
