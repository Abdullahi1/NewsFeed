package com.example.abdullahi.newsfeed.ui.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.abdullahi.newsfeed.data.repository.TopStoryRepository

class HomeViewModelFactory(
    private val topStoryRepository: TopStoryRepository,
    private val sectionName : String
) : ViewModelProvider.NewInstanceFactory(){
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(topStoryRepository, sectionName) as T
    }
}