package com.has.sam.cej.myuniversity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class Results : AppCompatActivity() {

    var webView: WebView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        webView = findViewById(R.id.wview)

        webView?.loadUrl("http://ebjntuhcej.p4o.net/consol/")

        //enable js
        var webSettings = webView?.getSettings()
        webSettings?.javaScriptEnabled = true

        webView?.setWebViewClient(WebViewClient())
        webView?.getSettings()?.builtInZoomControls = true
    }
}
