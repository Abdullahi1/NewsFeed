package com.example.newsfeed.ui.fragments.feedsection

import androidx.lifecycle.ViewModel
import com.example.newsfeed.data.repository.TopStoryRepository
import com.example.newsfeed.internal.lazyDeferred

class FeedViewModel(
    private val topStoryRepository: TopStoryRepository,
    private val sectionName : String

) : ViewModel() {

    val topStory by lazyDeferred{
        topStoryRepository.getCategoryTopStory(sectionName)
    }
}