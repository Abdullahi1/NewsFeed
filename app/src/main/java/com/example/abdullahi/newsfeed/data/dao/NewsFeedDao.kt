package com.example.abdullahi.newsfeed.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.abdullahi.newsfeed.data.network.response.TopStoryResponse
import com.example.abdullahi.newsfeed.utils.Result

@Dao
interface TopStoryDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(result: TopStoryResponse)

    @Query("SELECT * FROM top_story_news_feed WHERE id = :sectionId")
    fun getSectionFeed(sectionId : Int): LiveData<TopStoryResponse>
}