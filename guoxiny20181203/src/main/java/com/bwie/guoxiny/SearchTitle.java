package com.bwie.guoxiny;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SearchTitle extends LinearLayout {
    private Context context;
    private ImageView imageView;
    private EditText editText;
    private TextView textView;

    public SearchTitle(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public SearchTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }
    private OnImageClientListener imageClientListener;
    private void init() {
        View view = View.inflate(context,R.layout.search_title,null);
        imageView = view.findViewById(R.id.search_image);
        editText = view.findViewById(R.id.search_edit);
        textView = view.findViewById(R.id.search_text);
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageClientListener!=null){
                    imageClientListener.onImageClient(editText.getText().toString());
                }
            }
        });
        addView(view);
    }
    //定义接口
    public interface OnImageClientListener{
        void onImageClient(String str);
    }
    //实现set方法
    public void setImageClientListener(OnImageClientListener imageClientListener) {
        this.imageClientListener = imageClientListener;
    }
}
