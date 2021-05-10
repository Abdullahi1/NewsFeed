package com.example.newsfeed.data.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newsfeed.data.db.converter.MultimediaListConverter
import com.example.newsfeed.data.db.converter.ResultListConverter
import com.example.newsfeed.data.db.converter.StringListConverter
import com.example.newsfeed.data.network.response.TopStoryResponse

@Database(entities = [TopStoryResponse::class], version = 1, exportSchema = false)
@TypeConverters(StringListConverter::class, MultimediaListConverter::class, ResultListConverter::class)
abstract class NewsFeedDatabase : RoomDatabase() {

    abstract fun topStoryDao() : TopStoryDao

    companion object{
        private var instance : NewsFeedDatabase? = null

        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                NewsFeedDatabase::class.java, "newsFeedContainer.db")
                .build()
    }
}