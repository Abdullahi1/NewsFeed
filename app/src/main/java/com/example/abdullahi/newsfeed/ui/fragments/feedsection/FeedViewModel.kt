package com.example.abdullahi.newsfeed.ui.fragments.feedsection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.abdullahi.newsfeed.data.repository.TopStoryRepository
import com.example.abdullahi.newsfeed.internal.lazyDeferred

class FeedViewModel(
    private val topStoryRepository: TopStoryRepository,
    private val sectionName : String

) : ViewModel() {

    val topStory by lazyDeferred{
        topStoryRepository.getCategoryTopStory(sectionName)
    }
}