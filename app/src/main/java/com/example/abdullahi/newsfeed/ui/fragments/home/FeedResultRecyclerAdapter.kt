package com.example.abdullahi.newsfeed.ui.fragments.home

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.abdullahi.newsfeed.R
import com.example.abdullahi.newsfeed.internal.glide.GlideApp
import com.example.abdullahi.newsfeed.utils.Result
import com.github.marlonlom.utilities.timeago.TimeAgo
import com.github.marlonlom.utilities.timeago.TimeAgoMessages
import java.text.SimpleDateFormat
import java.util.*


class FeedResultRecyclerAdapter (
    private var feedResult : List<Result>?,
    private val context: Context
   ) : RecyclerView.Adapter<FeedResultRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_single_news,parent,false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        if (feedResult!!.isEmpty()) return 0

        return feedResult!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = feedResult!![position]
        holder.newsHeadline.text = result.title
        updateFeedImage(context, holder.newsImage,result)
        updateFeedTime(result.publishedDate)
        holder.newsTimeStamp.text = updateFeedTime(result.publishedDate)

        holder.itemView.setOnClickListener {
            Toast.makeText(it.context,result.content,Toast.LENGTH_SHORT).show()
        }

    }

    private fun updateFeedTime(publishedDate: String): String {
        val timeInMillis = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(publishedDate).time
        val messages = TimeAgoMessages.Builder().withLocale(Locale.ENGLISH).build()
        return TimeAgo.using(timeInMillis, messages)
    }

    private fun updateFeedImage(
        context: Context,
        newsImage: ImageView,
        result: Result
    ) {
        GlideApp.with(context)
            .load(result.multimedia[0].url)
            .into(newsImage)
    }

     fun updateFeed(newFeedResult : List<Result> ){
        if (this.feedResult!!.isEmpty()) this.feedResult = null

        this.feedResult = newFeedResult
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val newsImage : ImageView
        val newsHeadline : TextView
        val newsTimeStamp : TextView
        init {
            newsImage = itemView.findViewById(R.id.newsImage)
            newsHeadline = itemView.findViewById(R.id.newsHeadline)
            newsTimeStamp = itemView.findViewById(R.id.timeStamp)
        }
    }
}