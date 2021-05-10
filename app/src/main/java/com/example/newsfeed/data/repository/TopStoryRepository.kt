package com.example.newsfeed.data.repository

import androidx.lifecycle.LiveData
import com.example.newsfeed.data.network.response.TopStoryResponse

interface TopStoryRepository {
    suspend fun getCategoryTopStory(sectionName : String) : LiveData<out TopStoryResponse>
}