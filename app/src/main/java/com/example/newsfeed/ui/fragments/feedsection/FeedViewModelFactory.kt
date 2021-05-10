package com.example.newsfeed.ui.fragments.feedsection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsfeed.data.repository.TopStoryRepository

class FeedViewModelFactory(
    private val topStoryRepository: TopStoryRepository,
    private val sectionName : String
) : ViewModelProvider.NewInstanceFactory(){
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FeedViewModel(
            topStoryRepository,
            sectionName
        ) as T
    }
}