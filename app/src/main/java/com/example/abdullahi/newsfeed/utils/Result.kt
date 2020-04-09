package com.example.abdullahi.newsfeed.utils


import com.google.gson.annotations.SerializedName

data class Result(
    val `abstract`: String,
    val byline: String,
    @SerializedName("created_date")
    val createdDate: String,
    @SerializedName("des_facet")
    val desFacet: List<String>,
    @SerializedName("geo_facet")
    val geoFacet: List<String>,
    @SerializedName("item_type")
    val itemType: String,
    val kicker: String,
    @SerializedName("material_type_facet")
    val materialTypeFacet: String,
    val multimedia: List<Multimedia>,
    @SerializedName("org_facet")
    val orgFacet: List<String>,
    @SerializedName("per_facet")
    val perFacet: List<String>,
    @SerializedName("published_date")
    val publishedDate: String,
    val section: String,
    @SerializedName("short_url")
    val shortUrl: String,
    val subsection: String,
    val title: String,
    @SerializedName("updated_date")
    val updatedDate: String,
    val uri: String,
    val url: String,
    var content : String
)