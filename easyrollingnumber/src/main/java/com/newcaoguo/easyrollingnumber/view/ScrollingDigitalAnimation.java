package com.newcaoguo.easyrollingnumber.view;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;


public class ScrollingDigitalAnimation extends android.support.v7.widget.AppCompatTextView {

    private String numStart = "0";
    private String numEnd;

    private long duration = 2000; // 持续时间

    private String prefixString = ""; // 前缀字符串
    private String postfixString = ""; // 后缀字符串

    private boolean isInt = false;  // 是否为整数

    // 设置动画持续时间，默认 2000 ms
    public void setDuration(long duration){
        this.duration = duration;
    }


    public ScrollingDigitalAnimation(Context context) {
        super(context);
    }

    public ScrollingDigitalAnimation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollingDigitalAnimation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setNumberString(String number) {
        setNumberString("0", number);
    }

    public void setNumberString(String numStart, String numberEnd) {
        this.numStart = numStart;    // 得到设置的起始数字
        this.numEnd = numberEnd;     // 得到设置的结束数字
        if (checkNumString(numStart, numEnd)) {
            // 数字合法，开始数字的动画
            start();
        } else {
            // 数字不合法，直接调用，setText() 设置最终的值
            setText(prefixString + numberEnd + postfixString);
        }
    }

    /**
     * 设置前缀字符串方法
     *
     * @param prefixString
     */
    public void setPrefixString(String prefixString) {
        this.prefixString = prefixString;
    }

    /**
     * 设置后缀字符串方法
     *
     * @param postfixString
     */
    public void setPostfixString(String postfixString) {
        this.postfixString = postfixString;
    }

    private void start() {
        // 创建数字动画，并设置起始值和最终值
        ValueAnimator valueAnimator = ValueAnimator.ofObject(//
                new BigDecimalEvaluator(),//
                new BigDecimal(numStart), //
                new BigDecimal(numEnd));
        valueAnimator.setDuration(duration);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                BigDecimal value = (BigDecimal) animation.getAnimatedValue();
                setText(prefixString + format(value) + postfixString);
            }
        });
        valueAnimator.start();
    }

    /**
     * 格式化 BigDecimal ，小数部分时保留两位小数并四舍五入
     *
     * @param bd
     * @return
     */
    private String format(BigDecimal bd) {

        String pattern;
        if (isInt) {    // 如果是整数
            pattern = "#,###";  // 整数格式
        } else {
            pattern = "#,##0.00"; // 小数格式
        }
        // 进行格式化
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        // 返回格式化后的字符串
        return decimalFormat.format(bd);
    }

    // 计算线性插值器的结果
    static class BigDecimalEvaluator implements TypeEvaluator {

        @Override
        public Object evaluate(float fraction, Object startValue, Object endValue) {
            BigDecimal start = (BigDecimal) startValue;
            BigDecimal end = (BigDecimal) endValue;
            BigDecimal result = end.subtract(start);
            return result.multiply(new BigDecimal("" + fraction)).add(start);
        }
    }

    /**
     * 校验数字的合法性
     *
     * @param numStart
     * @param numEnd
     * @return
     */
    private boolean checkNumString(String numStart, String numEnd) {
        try {
            new BigInteger(numStart);
            new BigInteger(numEnd);
            isInt = true;

        } catch (Exception ex) {
            isInt = false;
            ex.printStackTrace();
        }

        try {
            BigDecimal start = new BigDecimal(numStart);    // 起始数字小数的筛选
            BigDecimal end = new BigDecimal(numEnd);    // 最终数字小数的筛选
            return end.compareTo(start) >= 0;   // 比较小数是否大于等于 0

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

}
