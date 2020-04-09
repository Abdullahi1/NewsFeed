package com.example.abdullahi.newsfeed.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.abdullahi.newsfeed.R
import com.example.abdullahi.newsfeed.data.NewsFeedApiService
import com.example.abdullahi.newsfeed.data.dao.NewsFeedDatabase
import com.example.abdullahi.newsfeed.data.network.datasource.FeedDataSourceImpl
import com.example.abdullahi.newsfeed.data.network.interceptor.ConnectivityInterceptorImpl
import com.example.abdullahi.newsfeed.data.repository.TopStoryRepositoryImpl
import com.example.abdullahi.newsfeed.ui.adapters.FeedResultRecyclerAdapter
import com.example.abdullahi.newsfeed.ui.base.ScopedFragment
import com.example.abdullahi.newsfeed.ui.fragments.feedsection.FeedViewModel
import com.example.abdullahi.newsfeed.ui.fragments.feedsection.FeedViewModelFactory
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch

class HomeFragment : ScopedFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        feedViewModel =
//            ViewModelProviders.of(this).get(FeedViewModel::class.java)
//                val textView: TextView = root.findViewById(R.id.text_home)
//        feedViewModel.text.observe(this, Observer {
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
       return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sectionsPagerAdapter = SectionsPagerAdapter(context!!, childFragmentManager)
        val viewPager: ViewPager = view.findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = view.findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
    }


//    private fun List<Result>.toFutureWeatherItems() : List<Result> {
//        return this.map {
//            FeedItem(it)
//        }
//    }
//
//    private fun initRecyclerView(items: List<Result>) {
//        val groupAdapter = GroupAdapter<ViewHolder>().apply {
//            addAll(items)
//        }
//
//        recyclerView.apply {
//            layoutManager = LinearLayoutManager(this@HomeFragment.context)
//            adapter = groupAdapter
//        }
//
//        groupAdapter.setOnItemClickListener { item, view ->
//            (item as? Result)?.let {
//                //showWeatherDetail(it.weatherEntry.date, view)
//                Toast.makeText(context,"Clicked",Toast.LENGTH_SHORT).show()
//
//            }
//        }
//    }

}
