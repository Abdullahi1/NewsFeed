package com.example.newsfeed.ui.fragments.feeddetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.newsfeed.newsfeed.R
import com.example.newsfeed.ui.base.ScopedFragment
import kotlinx.android.synthetic.main.top_story_detail_fragment.*
import android.net.http.SslError
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebResourceRequest
import android.os.Build
import android.annotation.TargetApi
import android.content.Context
import android.webkit.WebViewClient
import com.example.newsfeed.data.db.entity.Result


class TopStoryDetail : ScopedFragment() {
    private var listener: OnFragmentInteractionListener? = null


    private lateinit var viewModel: TopStoryDetailViewModel

    private lateinit var resultResponse: Result

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            resultResponse = it?.getSerializable("ARG_RESULT_RESPONSE") as Result
        }

        activity?.title = resultResponse.title
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.top_story_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProviders.of(this).get(TopStoryDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webview.settings.javaScriptEnabled = true
        webview.settings.loadsImagesAutomatically = true
        webview.settings.loadWithOverviewMode = true
        webview.settings.useWideViewPort = true

        webview.webViewClient = object : WebViewClient() {

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
                progressBar.visibility = View.INVISIBLE
            }

            override fun onReceivedSslError(
                view: WebView,
                handler: SslErrorHandler,
                error: SslError
            ) {
                handler.proceed()
            }
        }

        if (resultResponse != null) {
            webview.loadUrl(resultResponse.url)
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
//    fun onButtonPressed(uri: Uri) {
//        listener?.onFragmentInteraction(uri)
//    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onItemClicked(resultResponse: Result)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(resultResponse: Result) =
            TopStoryDetail().apply {
                arguments = Bundle().apply {
                    putSerializable("ARG_RESULT_RESPONSE", resultResponse)
                    //putString(ARG_PARAM2, param2)
                }
            }
    }

}
