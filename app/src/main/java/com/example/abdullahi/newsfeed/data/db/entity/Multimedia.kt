package com.example.abdullahi.newsfeed.data.db.entity

import java.io.Serializable


data class Multimedia(
    val caption: String,
    val copyright: String,
    val format: String,
    val height: Int,
    val subtype: String,
    val type: String,
    val url: String,
    val width: Int
):Serializable