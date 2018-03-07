package com.example.administrator.xiaoshutengweb;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView myWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    public void initView() {
        myWebview = findViewById(R.id.myWeb);
    }

    public void initData() {
        //方式1. 加载一个网页：
        myWebview.loadUrl("http://www.fanhucm.com/0000/index/index2.html");
        //声明WebSettings子类
        WebSettings webSettings = myWebview.getSettings();
        // 设置WebView属性，页面文本编码
        webSettings.setDefaultTextEncodingName("utf-8");
        // 设置WebView属性，能够执行Javascript脚本
        webSettings.setJavaScriptEnabled(true);
        // 页面表示的 url 的处理（action）
        myWebview.setWebViewClient(new WebViewClient());
        // 页面 alert 警告框和 Confirm 确认框的处理
        myWebview.setWebChromeClient(new WebChromeClient());
        myWebview.onResume();
        //当页面被失去焦点被切换到后台不可见状态，需要执行onPause
        //是否可以后退
        myWebview.canGoBack();
        //后退网页
        myWebview.goBack();
        //是否可以前进
        myWebview.canGoForward();
        //前进网页
        myWebview.goForward();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (myWebview.canGoBack()) {
                myWebview.goBack();//返回上一页面
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
