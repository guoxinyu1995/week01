package com.bwie.guoxiny;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class SearchContent extends LinearLayout {
    /**
     * 孩子中最高的
     */
    private int mChildHeight;
    /**
     * 左右间距
     */
    private int mHSpect = 20;
    /**
     * 上下间距
     */
    private int mVSpect = 20;

    public SearchContent(Context context) {
        super(context);
    }

    public SearchContent(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //得到父容器的宽高
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSixe = MeasureSpec.getSize(heightMeasureSpec);
        //测量孩子的宽高
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        //寻找孩子中最高的一个
        findChildMaxHeight();
        //初始化值
        int top = 0, left = 0;
        //循环所有的孩子
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if (left != 0) {
                if ((left + view.getMeasuredWidth()) > widthSize) {
                    top += mChildHeight + mVSpect;
                    left = 0;
                }
            }
            left += getMeasuredWidth() + mHSpect;
        }
        setMeasuredDimension(widthSize, (top + mChildHeight) > heightSixe ? heightSixe : top + mChildHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        //寻找孩子中最高的一个
        findChildMaxHeight();
        //初始化值
        int top = 0, left = 0;
        //循环所有的孩子
        int childCount = getChildCount();
        for (int i = 0;i<childCount;i++){
            View view = getChildAt(i);
            if (left != 0) {
                if ((left + view.getMeasuredWidth()) > getWidth()) {
                    top += mChildHeight + mVSpect;
                    left = 0;
                }
            }
            view.layout(left,top,left+view.getMeasuredWidth(),top+mChildHeight);
            left += getMeasuredWidth() + mHSpect;
        }
    }

    //寻找孩子中最高的一个
    private void findChildMaxHeight() {
        mChildHeight = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if (view.getMeasuredHeight() > mChildHeight) {
                mChildHeight = view.getMeasuredHeight();
            }
        }
    }
}
