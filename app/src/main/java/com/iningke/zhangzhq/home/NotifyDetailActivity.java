package com.iningke.zhangzhq.home;

import android.content.Intent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.iningke.zhangzhq.R;
import com.iningke.zhangzhq.base.ZhangzhqActivity;

import butterknife.Bind;

/**
 * 通知详情页面 webview
 *
 * @author hxy
 * @date 2016/12/11
 */
public class NotifyDetailActivity extends ZhangzhqActivity {

    @Bind(R.id.notify_detail_webView)
    WebView webView;

    @Override
    public int setLayoutId() {
        return R.layout.activity_notify_detail;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        String webUrl = intent.getStringExtra("webUrl");
        if (!"".equals(webUrl) && null != webUrl) {
            aboutWebView(webUrl);
        }
    }

    private void aboutWebView(String webUrl) {
        WebSettings settings = webView.getSettings();
        settings.setBuiltInZoomControls(false);
        settings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webView.setHorizontalScrollBarEnabled(false);//滚动条水平不显示
        webView.setVerticalScrollBarEnabled(false); //滚动条垂直不显示
        webView.loadUrl(webUrl);
    }

    @Override
    public void initData() {

    }
}
