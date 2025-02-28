package com.hiro.take.myapplication
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.app.Activity

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        val myWebView: WebView = findViewById(R.id.webview)
					 myWebView.loadUrl("https://www.google.co.jp/")
			
		}
		
}
