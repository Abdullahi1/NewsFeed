package com.example.newsfeed.data.network.response


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newsfeed.data.db.entity.Result
import com.google.gson.annotations.SerializedName

@Entity(tableName = "top_story_news_feed")
data class TopStoryResponse(

    @PrimaryKey(autoGenerate = false)
    var id : Int? = null,

    val copyright: String,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("num_results")
    val numResults: Int,
    val results: List<Result>,
    val section: String,
    val status: String
)