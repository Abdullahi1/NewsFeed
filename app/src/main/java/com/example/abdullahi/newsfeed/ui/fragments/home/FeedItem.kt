package com.example.abdullahi.newsfeed.ui.fragments.home

import android.widget.ImageView
import android.widget.TextView
import com.example.abdullahi.newsfeed.R
import com.example.abdullahi.newsfeed.data.network.response.TopStoryResponse
import com.example.abdullahi.newsfeed.internal.glide.GlideApp
import com.example.abdullahi.newsfeed.utils.Result
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder

class FeedItem(
    //private val topStoryResponse: TopStoryResponse,
    private val result: Result
) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.apply {
            updateFeedImage()
            updateFeedHeadLine()
            updateFeedTimeStamp()

        }
    }

    private fun ViewHolder.updateFeedTimeStamp() {
        val timeStamp : TextView = containerView.findViewById(R.id.timeStamp)
        timeStamp.text = result.title
    }

    private fun ViewHolder.updateFeedHeadLine() {
        val headline : TextView = containerView.findViewById(R.id.newsHeadline)
        headline.text = result.title
    }

    private fun ViewHolder.updateFeedImage() {
        val myImage : ImageView = containerView.findViewById(R.id.newsImage)
        GlideApp.with(this.containerView)
            .load(result.multimedia[0].url)
            .into(myImage)
    }

    override fun getLayout() = R.layout.layout_single_news
}