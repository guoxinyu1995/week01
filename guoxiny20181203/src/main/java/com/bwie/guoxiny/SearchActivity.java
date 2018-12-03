package com.bwie.guoxiny;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    private SearchTitle title;
    private SearchContent lately;
    private SearchContent discover;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //获取资源id
        title = findViewById(R.id.title);
        lately = findViewById(R.id.lately);
        discover = findViewById(R.id.discover);
        imageView = findViewById(R.id.image_clear);
        initData();
    }

    private void initData() {
        title.setImageClientListener(new SearchTitle.OnImageClientListener() {
            @Override
            public void onImageClient(final String str) {
                if(str.equals("")){
                    return;
                }else{
                    TextView textView = new TextView(SearchActivity.this);
                    textView.setText(str);
                    SearchDao.getIntence(SearchActivity.this).add(str);
                    textView.setTextColor(Color.RED);
                    textView.setTextSize(20);
                    textView.setBackgroundResource(R.drawable.text_shape);
                    lately.addView(textView);
                    //点击吐司
                    textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(SearchActivity.this,"点击了"+str,Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        final String[] str = new String[]{
                "电动牙刷","豆豆鞋","沐浴露","榴莲","尤妮佳","清洁"};
        for(int i = 0;i<str.length;i++){
            TextView textView = new TextView(SearchActivity.this);
            textView.setText(str[i]);
            textView.setTextColor(Color.RED);
            textView.setTextSize(20);
            textView.setBackgroundResource(R.drawable.text_shape);
            discover.addView(textView);
            final int index = i;
            //点击吐司
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SearchActivity.this,"点击了"+str[index],Toast.LENGTH_SHORT).show();
                }
            });
            //清空
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lately.removeAllViews();
                }
            });
        }
    }
}
