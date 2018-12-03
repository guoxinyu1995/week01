package com.bwie.guoxiny;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class SearchName extends TextView {
    public SearchName(Context context) {
        super(context);
    }

    public SearchName(Context context,AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.SearchName);
        int color = array.getColor(R.styleable.SearchName_textColor, Color.BLUE);
        setTextColor(color);
        array.recycle();
    }
}
