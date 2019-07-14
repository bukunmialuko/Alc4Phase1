

package com.andela.alc4phase1;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.agrawalsuneet.loaderspack.loaders.RingAndCircleLoader;

public class AboutActivity1 extends AppCompatActivity {


    private WebView mWebView;
    private ProgressBar ringAndCircleLoader;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about1);
        initWidgets();
        bindWidgets();
        loadWebPage();

    }

    private void loadWebPage() {
        String url = "https://andela.com/alc/";
        mWebView.loadUrl(url);
    }

    private void initWidgets() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mWebView = findViewById(R.id.web_view);

        ringAndCircleLoader =  findViewById(R.id.progress_bar);


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void bindWidgets() {
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);

        mWebView.setWebContentsDebuggingEnabled(false);
        mWebView.getSettings().setAppCacheEnabled(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.setHorizontalScrollBarEnabled(false);
        mWebView.setVerticalScrollBarEnabled(false);


        mWebView.setWebViewClient(new MyAppWebViewClient(getApplicationContext(), ringAndCircleLoader));
    }


    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

}

