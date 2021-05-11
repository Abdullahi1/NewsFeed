package com.example.newsfeed.ui.activities

import android.annotation.TargetApi
import android.net.http.SslError
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.webkit.SslErrorHandler
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.newsfeed.data.db.entity.Result
import com.example.newsfeed.databinding.ActivityTopStoryDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

@AndroidEntryPoint
class TopStoryDetailsActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var resultResponse : Result
    private lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    private lateinit var binding: ActivityTopStoryDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTopStoryDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        job = Job()

        resultResponse = intent.getSerializableExtra("ARG_RESULT_RESPONSE") as Result

        if (resultResponse != null) {
            title = resultResponse.title
            loadStoryUrl(resultResponse)
        }
    }

    private fun loadStoryUrl(resultResponse: Result) = launch {

        binding.webview.settings.javaScriptEnabled = true
        binding.webview.settings.loadsImagesAutomatically = true
        binding.webview.settings.loadWithOverviewMode = true
        binding.webview.settings.useWideViewPort = true

        binding.webview.webViewClient = object : WebViewClient() {

            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            override fun shouldOverrideUrlLoading(
                view: WebView,
                request: WebResourceRequest
            ): Boolean {
                //return super.shouldOverrideUrlLoading(view, request);
                view.loadUrl(request.url.toString())
                return true
            }

            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                //  return super.shouldOverrideUrlLoading(view, url);
                view.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView, url: String) {
                //super.onPageFinished(view, url);
                binding.progressBar.visibility = View.INVISIBLE
            }

            override fun onReceivedSslError(
                view: WebView,
                handler: SslErrorHandler,
                error: SslError
            ) {
                handler.proceed()
            }
        }

            binding.webview.loadUrl(resultResponse.url)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}
