package com.example.abdullahi.newsfeed.ui.fragments.feedsection.sports

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.abdullahi.newsfeed.R
import com.example.abdullahi.newsfeed.data.NewsFeedApiService
import com.example.abdullahi.newsfeed.data.dao.NewsFeedDatabase
import com.example.abdullahi.newsfeed.data.network.datasource.FeedDataSourceImpl
import com.example.abdullahi.newsfeed.data.network.interceptor.ConnectivityInterceptorImpl
import com.example.abdullahi.newsfeed.data.repository.TopStoryRepository
import com.example.abdullahi.newsfeed.data.repository.TopStoryRepositoryImpl
import com.example.abdullahi.newsfeed.di.ContextModule
import com.example.abdullahi.newsfeed.di.DaggerAppComponent
import com.example.abdullahi.newsfeed.ui.adapters.FeedResultRecyclerAdapter
import com.example.abdullahi.newsfeed.ui.base.ScopedFragment
import com.example.abdullahi.newsfeed.ui.fragments.feedsection.FeedViewModel
import com.example.abdullahi.newsfeed.ui.fragments.feedsection.FeedViewModelFactory
import kotlinx.android.synthetic.main.fragment_sports.*
import kotlinx.coroutines.launch
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SportsFragment : ScopedFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var feedViewModel: FeedViewModel
    private lateinit var recyclerAdapter : FeedResultRecyclerAdapter

    @Inject lateinit var topStoryRepository  : TopStoryRepository


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sports, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerAdapter = FeedResultRecyclerAdapter(
            listOf(),
            context!!
        )
        recyclerView.layoutManager = LinearLayoutManager(context!!)
        recyclerView.adapter = recyclerAdapter
//        val connectivityInterceptor = ConnectivityInterceptorImpl(context!!)
//        val apiService = NewsFeedApiService(connectivityInterceptor)
//        val feedDataSource = FeedDataSourceImpl(apiService)
//        val db = NewsFeedDatabase.invoke(context!!)
//        val topStoryRepository  = TopStoryRepositoryImpl(db.topStoryDao(),feedDataSource)

        val factory = FeedViewModelFactory(
            topStoryRepository,
            "sports"
        )
        feedViewModel = ViewModelProvider(this,factory).get(FeedViewModel::class.java)

        bindUi()
    }

    private fun bindUi() = launch {
        val topStory = feedViewModel.topStory.await()

        topStory.observe(this@SportsFragment, Observer {
            if (it == null) return@Observer

            //text_home.text = it.toString()
            group_loading.visibility = View.GONE

            //initRecyclerView(it.results)
            recyclerAdapter.updateFeed(it.results)


        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerAppComponent.builder().contextModule(ContextModule(context)).build().inject(this)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SportsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            SportsFragment()
    }
}
