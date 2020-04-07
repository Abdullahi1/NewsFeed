package com.example.abdullahi.newsfeed.data.repository

import androidx.lifecycle.LiveData
import com.example.abdullahi.newsfeed.data.network.response.TopStoryResponse

interface TopStoryRepository {
    suspend fun getCategoryTopStory(sectionName : String) : LiveData<out TopStoryResponse>
}