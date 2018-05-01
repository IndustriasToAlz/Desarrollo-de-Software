package com.example.user.clasecesar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("https://testwappas.sirv.com/Images/productos/168_2017/168_IN079_20171215040939837_Catalogo-Gold-Filled-015.jpg");
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverriceUrlLoading(WebView view, String url) {
                return false;
            }
        });
    }
}
