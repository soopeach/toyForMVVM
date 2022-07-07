package com.soopeach.movietoyproject.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class SearchDataList(
    val display: Int,
    val items: List<Item>,
    val lastBuildDate: String,
    val start: Int,
    val total: Int
) {
    @Parcelize
    data class Item(
        val actor: String,
        val director: String,
        val image: String,
        val link: String,
        val pubDate: String,
        val subtitle: String,
        val title: String,
        val userRating: String
    ) : Parcelable
}

fun SearchDataList.getItem() : List<SearchDataList.Item> {
    return items
}