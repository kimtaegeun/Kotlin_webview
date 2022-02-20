package com.example.kotlin_webview

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.webkit.WebView
import android.widget.EditText
import android.widget.ImageButton
import androidx.core.widget.ContentLoadingProgressBar

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {
    private val webView: WebView by lazy { findViewById(R.id.webview) }
    private val addrET: EditText by lazy { findViewById(R.id.addrET) }
    private val homeBT: ImageButton by lazy { findViewById(R.id.homeBT) }
    private val backBT: ImageButton by lazy { findViewById(R.id.backBT) }
    private val forwardBT: ImageButton by lazy { findViewById(R.id.forwardBT) }
    private val swipeRL: SwipeRefreshLayout by lazy { findViewById(R.id.swipeRL) }
    private val progressbar: ContentLoadingProgressBar by lazy { findViewById(R.id.progressbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        bindviews()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initView() {
        webView.apply {
            webViewClient = WebviewClient()
            // 테스트
            webChromeClient = WebChromeClient()
            // 테스트2
            settings.javaScriptEnabled = true
            // 테스트3번
            loadUrl(DEFAULT_URL)
            //t1브랜치에서 작업
            //t2브랜치에서 작업
            //?????
            //?????
            //????????
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } //웹뷰에서 뒤로 갈수 있으면
        else {
            super.onBackPressed()
        }
    }

    private fun bindviews() {
        swipeRL.setOnRefreshListener {
            webView.reload()
                // kk 에서 작업
            //ll브랜치 작업
            //swjang
            //tgkim
            //333
            //ijojoijoi
            //awkdoaskdo
            //akodwoakd
            //44444
            //5555
            //11111

        }

        backBT.setOnClickListener {
            webView.goBack()
        }
        forwardBT.setOnClickListener {
            webView.goForward()
        }
        homeBT.setOnClickListener {
            webView.loadUrl(DEFAULT_URL)
        }

        addrET.setOnEditorActionListener { textView, i, _ ->
            if (i == EditorInfo.IME_ACTION_DONE) {
                webView.loadUrl(textView.text.toString())
            }
            return@setOnEditorActionListener false
        }
    }

    inner class WebviewClient : android.webkit.WebViewClient() {
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            swipeRL.isRefreshing = false
            progressbar.hide()
            backBT.isEnabled = webView.canGoBack()

        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            progressbar.show()
        }
    }
        inner class WebChromeClient : android.webkit.WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                progressbar.progress = newProgress
            }
        }


    companion object {
        private const val DEFAULT_URL = "http://www.naver.com"
    }
}