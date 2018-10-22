package com.example.admin.mfvtest.Model

import android.os.Parcel
import android.os.Parcelable
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
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.createStringArrayList(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(pubDate)
        parcel.writeString(dc_creator)
        parcel.writeStringList(category)
        parcel.writeString(description)
        parcel.writeString(image)
        parcel.writeString(detail)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ArticleContent> {
        override fun createFromParcel(parcel: Parcel): ArticleContent {
            return ArticleContent(parcel)
        }

        override fun newArray(size: Int): Array<ArticleContent?> {
            return arrayOfNulls(size)
        }
    }
}
