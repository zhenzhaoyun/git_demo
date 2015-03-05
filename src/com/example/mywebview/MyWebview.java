package com.example.mywebview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MyWebview extends Activity implements OnClickListener {

	private WebView mWebview;
	private Button back;
	private Button next;
	private Button refresh;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview);
		init();
	}

	private void init() {
		back=(Button) findViewById(R.id.back);
		back.setOnClickListener(this);
		next=(Button) findViewById(R.id.next);
		next.setOnClickListener(this);
		refresh=(Button) findViewById(R.id.refresh);
		refresh.setOnClickListener(this);
		
		mWebview = (WebView) findViewById(R.id.mwvw);
//		mWebview.loadUrl("http://www.apengdai.com/appdownload");
		WebSettings webSettings = mWebview.getSettings();
		webSettings.setJavaScriptEnabled(true);
		// 要打开用户点击的链接，只需要用setWebViewClient()方法向你的WebView提供一个WebViewClient
		mWebview.setWebViewClient(new WebViewClient());
		// 如果页面中链接，如果希望点击链接继续在当前browser中响应，而不是新开Android的系统browser中响应该链接，必须覆盖
		// webview的WebViewClient对象。
		mWebview.setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});
		mWebview.loadUrl("http://www.baidu.com/");
		//设置网页适应手机屏幕
		webSettings.setLoadWithOverviewMode(true);
		webSettings.setUseWideViewPort(true);
		//其他的一些设置
		//测试能不能本地更新git里边的代码
		webSettings.setSupportZoom(true);// 缩放
		mWebview.zoomIn();//放大
		mWebview.zoomOut();//缩小
		webSettings.setDomStorageEnabled(true);
		webSettings.setLoadsImagesAutomatically(true);
		webSettings.setPluginsEnabled(true); // 支持插件  surf
		webSettings.setUserAgent(0); // 0为手机默认, 1为PC台机，2为IPHONE
		webSettings.setDefaultTextEncodingName("utf-8");
//
		webSettings.setUseWideViewPort(true);
		webSettings.setLoadWithOverviewMode(true);
		webSettings.setBuiltInZoomControls(true);// 支持手势缩放
//		webSettings.setDisplayZoomControls(false);// 支持手势缩放
	
	}
	

	@Override
	public void onClick(View v) {
			switch (v.getId()) {
			case R.id.back:
				if (mWebview.canGoBack()) {       
					mWebview.goBack();
				}       
				break;
			case R.id.next:
				if (mWebview.canGoForward()) {       
					mWebview.goForward();
				}       
				break;
			case R.id.refresh:
					mWebview.goBack();
				break;

			default:
				break;
			}
	}    
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {       
		if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebview.canGoBack()) {       
			mWebview.goBack();       
			return true;       
		}       
		return super.onKeyDown(keyCode, event);       
	}
}
