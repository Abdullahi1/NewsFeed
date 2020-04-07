package com.example.abdullahi.newsfeed.data.network.datasource

import androidx.lifecycle.LiveData
import com.example.abdullahi.newsfeed.data.network.response.TopStoryResponse
import com.example.abdullahi.newsfeed.utils.Result

interface FeedDataSource {
    val downloadTopFeed : LiveData<TopStoryResponse>

    suspend fun fetchTopFeed(
        sectionName : String
    )

    
}