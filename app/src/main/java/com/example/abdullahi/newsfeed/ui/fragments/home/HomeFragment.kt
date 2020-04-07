package com.example.abdullahi.newsfeed.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.abdullahi.newsfeed.R
import com.example.abdullahi.newsfeed.data.NewsFeedApiService
import com.example.abdullahi.newsfeed.data.dao.NewsFeedDatabase
import com.example.abdullahi.newsfeed.data.network.datasource.FeedDataSourceImpl
import com.example.abdullahi.newsfeed.data.network.interceptor.ConnectivityInterceptor
import com.example.abdullahi.newsfeed.data.network.interceptor.ConnectivityInterceptorImpl
import com.example.abdullahi.newsfeed.data.repository.TopStoryRepositoryImpl
import com.example.abdullahi.newsfeed.ui.base.ScopedFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : ScopedFragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        homeViewModel =
//            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(this, Observer {
//            //textView.text = it
//        })
//
//        GlobalScope.launch (Dispatchers.Main){
//            val apiService = NewsFeedApiService()
//            val feedDataSource = FeedDataSourceImpl(apiService)
//            val db = NewsFeedDatabase.invoke(context!!)
//            val topStoryRepository  = TopStoryRepositoryImpl(db.topStoryDao(),feedDataSource)
//            val response = apiService.getCategoryTopStory("home").await()
//            response.id = 1
//            textView.text = response.toString()
//
//        }
       return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            val connectivityInterceptor = ConnectivityInterceptorImpl(context!!)
            val apiService = NewsFeedApiService(connectivityInterceptor)
            val feedDataSource = FeedDataSourceImpl(apiService)
            val db = NewsFeedDatabase.invoke(context!!)
            val topStoryRepository  = TopStoryRepositoryImpl(db.topStoryDao(),feedDataSource)

        val factory = HomeViewModelFactory(topStoryRepository,"home")
        homeViewModel = ViewModelProvider(this,factory).get(HomeViewModel::class.java)

        bindUi()
    }

    private fun bindUi() = launch {
        val topStory = homeViewModel.topStory.await()

        topStory.observe(this@HomeFragment, Observer {
            if (it == null) return@Observer

            text_home.text = it.toString()
        })
    }
}