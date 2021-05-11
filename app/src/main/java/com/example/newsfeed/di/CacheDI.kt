package com.example.newsfeed.di

import android.content.Context
import androidx.room.Room
import com.example.newsfeed.data.dao.NewsFeedDatabase
import com.example.newsfeed.data.dao.TopStoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DBModule {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): NewsFeedDatabase {
        return Room.databaseBuilder(
            context,
            NewsFeedDatabase::class.java,
            "newsFeedContainer.db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesAgentDao(database: NewsFeedDatabase): TopStoryDao {
        return database.topStoryDao()
    }
}