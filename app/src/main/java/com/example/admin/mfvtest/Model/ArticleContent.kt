package com.example.admin.mfvtest.Model

import com.google.gson.annotations.SerializedName

/**
 * Created by admin on 10/19/2018.
 */


data class ArticleContent(
        var title: String,
        var pubDate: String,
        @SerializedName("dc:creator")
        var dc_creator: String,
        var category: List<String>,
        var description: String,
        var image: String,
        var detail: String
)
