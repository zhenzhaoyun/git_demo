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
		// Ҫ���û���������ӣ�ֻ��Ҫ��setWebViewClient()���������WebView�ṩһ��WebViewClient
		mWebview.setWebViewClient(new WebViewClient());
		// ���ҳ�������ӣ����ϣ��������Ӽ����ڵ�ǰbrowser����Ӧ���������¿�Android��ϵͳbrowser����Ӧ�����ӣ����븲��
		// webview��WebViewClient����
		mWebview.setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});
		mWebview.loadUrl("http://www.baidu.com/");
		//������ҳ��Ӧ�ֻ���Ļ
		webSettings.setLoadWithOverviewMode(true);
		webSettings.setUseWideViewPort(true);
		//������һЩ����
		webSettings.setSupportZoom(true);// ����
		mWebview.zoomIn();//�Ŵ�
		mWebview.zoomOut();//��С
		webSettings.setDomStorageEnabled(true);
		webSettings.setLoadsImagesAutomatically(true);
		webSettings.setPluginsEnabled(true); // ֧�ֲ��  surf
		webSettings.setUserAgent(0); // 0Ϊ�ֻ�Ĭ��, 1ΪPC̨����2ΪIPHONE
		webSettings.setDefaultTextEncodingName("utf-8");
//
		webSettings.setUseWideViewPort(true);
		webSettings.setLoadWithOverviewMode(true);
		webSettings.setBuiltInZoomControls(true);// ֧����������
//		webSettings.setDisplayZoomControls(false);// ֧����������
	
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
