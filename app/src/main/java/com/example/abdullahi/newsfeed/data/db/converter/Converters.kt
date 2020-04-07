package com.example.abdullahi.newsfeed.data.db.converter

import androidx.room.TypeConverter
import com.example.abdullahi.newsfeed.utils.Multimedia
import com.example.abdullahi.newsfeed.utils.Result
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class StringListConverter{

    @TypeConverter
    fun stringToList(data : String): List<String>{
        if (data == null){
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<String>>(){}.type
        return  Gson().fromJson(data,listType)
    }

    @TypeConverter
    fun listToString(list: List<String>) : String{
        val type = object : TypeToken<List<String>>(){}.type
        return Gson().toJson(list, type)
    }
}

class ResultListConverter{

    @TypeConverter
    fun stringToList(data : String): List<Result>{
        if (data == null){
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<Result>>(){}.type
        return  Gson().fromJson(data,listType)
    }

    @TypeConverter
    fun listToString(list: List<Result>) : String{
        val type = object : TypeToken<List<Result>>(){}.type
        return Gson().toJson(list, type)
    }
}

class MultimediaListConverter{
    @TypeConverter
    fun stringToList(data : String): List<Multimedia>{
        if (data == null){
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<Multimedia>>(){}.type
        return  Gson().fromJson(data,listType)
    }

    @TypeConverter
    fun listToStrings(list: List<Multimedia>) : String{
        val type = object : TypeToken<List<Multimedia>>(){}.type
        return Gson().toJson(list, type)
    }
}