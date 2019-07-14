package com.andela.alc4phase1;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MyAppWebViewClient extends WebViewClient {

    private Context mContext;

    public MyAppWebViewClient(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        Toast.makeText(mContext, description, Toast.LENGTH_SHORT).show();
    }

    @TargetApi(android.os.Build.VERSION_CODES.M)
    @Override
    public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
        // Redirect to deprecated method, so you can use it in all SDK versions
        onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
    }
}
