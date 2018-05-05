package com.newcaoguo.rollingnumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.newcaoguo.easyrollingnumber.view.ScrollingDigitalAnimation;

public class MainActivity extends AppCompatActivity {

    private ScrollingDigitalAnimation money;    // 显示金钱的自定义控件
    private ScrollingDigitalAnimation number;  // 显示数字的自定义控件
    private ScrollingDigitalAnimation percentage; // 显示百分比的自定义控件


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        money = findViewById(R.id.text);
        number = findViewById(R.id.text1);
        percentage = findViewById(R.id.text2);
    }


    /**
     * 启动按钮单击事件
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
}
