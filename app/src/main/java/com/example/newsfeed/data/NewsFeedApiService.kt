package com.example.newsfeed.data

import com.example.newsfeed.data.network.interceptor.ConnectivityInterceptor
import com.example.newsfeed.data.network.response.TopStoryResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


const val API_KEY = "zsWKjQjfhE9P7QUGMReMppfx6FnTICGk"
const val SECRET_KEY = "WNsGbNR2HUQTlk9A"
const val BASE_URL = "https://api.nytimes.com/svc/topstories/v2/"
//https://api.nytimes.com/svc/topstories/v2/home.json?api-key=zsWKjQjfhE9P7QUGMReMppfx6FnTICGk
interface NewsFeedApiService {

    @GET("{sectionName}.json")
    fun getCategoryTopStory(
        @Path("sectionName") sectionName: String
    ) : Deferred<TopStoryResponse>


    companion object{
        operator fun invoke(
            connectivityInterceptor : ConnectivityInterceptor
        ):NewsFeedApiService{

            val requestInterceptor = Interceptor{chainInterceptor->

                val url = chainInterceptor.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("api-key", API_KEY)
                    .build()

                val request = chainInterceptor.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chainInterceptor.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(connectivityInterceptor)
                .addInterceptor(requestInterceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(NewsFeedApiService::class.java)
        }
    }
}