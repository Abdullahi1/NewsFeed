package com.example.newsfeed.data.network.datasource

import androidx.lifecycle.LiveData
import com.example.newsfeed.data.network.response.TopStoryResponse

interface FeedDataSource {
    val downloadTopFeed : LiveData<TopStoryResponse>

    suspend fun fetchTopFeed(
        sectionName : String
    )

    
}