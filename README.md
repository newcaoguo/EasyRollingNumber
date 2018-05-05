# 1. EasyRollingNumber项目介绍
 > 🍎 `EasyRollingNumber` 项目是用来轻松实现滚动数字效果的一个库。


[![](https://jitpack.io/v/newcaoguo/EasyRollingNumber.svg)](https://jitpack.io/#newcaoguo/EasyRollingNumber)

## 2. 效果展示

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
1) 在布局文件中添加如下代码，与一般控件相同
```java
<com.newcaoguo.easyrollingnumber.view.ScrollingDigitalAnimation
        android:id="@+id/text1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="52dp"
        android:textSize="28sp" />
```
2) 在 Activity 中声明 自定义控件的变量
```java
    // 显示金钱的自定义控件
    private ScrollingDigitalAnimation money;    
    // 显示数字的自定义控件
    private ScrollingDigitalAnimation number;  
    // 显示百分比的自定义控件
    private ScrollingDigitalAnimation percentage; 
```
3) 初始化控件
```java
        money = findViewById(R.id.text);
        number = findViewById(R.id.text1);
        percentage = findViewById(R.id.text2);
```

4) 设置一个响应事件，并在方法里面配置相关属性
```java
    /**
     * 启动按钮单击事件
     * @author newcaoguo
     */
    public void start(View view) {
        money.setPrefixString("¥");//设置符号
        money.setNumberString("9", "9999999999");//设置起始于结束的数字
        money.setDuration(3000);
        number.setNumberString("1234567890");
        number.setDuration(4000);
        percentage.setPostfixString("%");
        percentage.setNumberString("0.99", "99.99");
        percentage.setDuration(5000);
    }
```


### 5. API 说明

| API 名称        | 含 义   |  默 认 值  |
| --------   | -----:  | :----:  |
| setPrefixString(String prefixString)    | 设置前缀字符串 |   空     |
| setPostfixString(String postfixString)        |   设置后缀字符串  |   空   |
| setDuration(long duration)        |    设置动画持续时间    |  2000 ms  |
