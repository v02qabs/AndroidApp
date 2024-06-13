package com.hiro.mywebview;

import android.os.Bundle;
import android.app.Activity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends Activity {

    private static final int REQUEST_CODE = 1;

       private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

	FloatingActionButton fab = findViewById(R.id.fab);


        webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());  // 画面遷移を WebView 内で処理する
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);  // JavaScript を有効にする

        webView.loadUrl("https://www.google.co.jp");
    }
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();  // WebView でバック可能ならバックする
        } else {
            super.onBackPressed();
        }
    }
}

