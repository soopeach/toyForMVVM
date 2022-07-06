package com.soopeach.movietoyproject.utils

import android.content.Context
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.soopeach.movietoyproject.R
import com.soopeach.movietoyproject.adapters.RankListAdapter
import com.soopeach.movietoyproject.adapters.SearchListAdapter
import com.soopeach.movietoyproject.models.RankDetail
import com.soopeach.movietoyproject.models.RankList
import com.soopeach.movietoyproject.models.SearchDataList

class BindingUtils {
}

@BindingAdapter("hintForSearch")
fun setHintForSearch(editText: android.widget.EditText, hint: String) {
    editText.hint = "검색 예시 ex) " + hint
}

@BindingAdapter("rankListData")
fun bindRecyclerView(recyclerView: androidx.recyclerview.widget.RecyclerView, data: List<RankList.BoxOfficeResult.DailyBoxOffice>?) {
    val adapter = recyclerView.adapter as RankListAdapter
    adapter.submitList(data)
}

@BindingAdapter("rankRank")
fun setRankRank(textView: android.widget.TextView, item: RankList.BoxOfficeResult.DailyBoxOffice?) {
    textView.text = item?.rank + "위"
}

@BindingAdapter("rankTitle")
fun setRankTitle(textView: android.widget.TextView, item: RankList.BoxOfficeResult.DailyBoxOffice?) {
    textView.text = item?.movieNm
}

@BindingAdapter("rankOpenDt")
fun setRankOpenDt(textView: android.widget.TextView, item: RankList.BoxOfficeResult.DailyBoxOffice?) {
    textView.text = "개봉일 : " + item?.openDt
}

@BindingAdapter("rankAudiAcc")
fun setRankAudiAcc(textView: android.widget.TextView, item: RankList.BoxOfficeResult.DailyBoxOffice?) {
    textView.text = "누적 관객수 : " + item?.audiAcc
}

@BindingAdapter("searchListData")
fun bindRecyclerViewForSearch(recyclerView: androidx.recyclerview.widget.RecyclerView, data: List<SearchDataList.Item>?) {
    val adapter = recyclerView.adapter as SearchListAdapter
    adapter.submitList(data)
}

@BindingAdapter("searchTitle")
fun setSearchTitle(textView: android.widget.TextView, item: SearchDataList.Item?) {
    textView.text = "제목 : " + item?.title?.getForMatted()
}

@BindingAdapter("searchUserRating")
fun setSearchUserRating(textView: android.widget.TextView, item: SearchDataList.Item?) {
    textView.text = "평점 : " + item?.userRating
}

@BindingAdapter("searchPubDate")
fun setSearchPubDate(textView: android.widget.TextView, item: SearchDataList.Item?) {
    textView.text = "개봉일자 : " + item?.pubDate
}

@BindingAdapter("searchImage")
fun setSearchImage(imageView: android.widget.ImageView, item: SearchDataList.Item?){
    val url = item?.image
    Glide.with(imageView.context).load(url).placeholder(R.drawable.downloading).into(imageView)
}

fun String.getForMatted() : String {
    return this.replace("<b>", "").replace("</b>", "")
}
// 아래는 Detil 관련
@BindingAdapter("rankDetailTitle")
fun setRankDetailTitle(textView: android.widget.TextView, item: RankDetail.MovieInfoResult.MovieInfo?) {
    textView.text = item?.movieNm
}

@BindingAdapter("rankDetailGenre")
fun setRankDtailGenre(textView: android.widget.TextView, item: RankDetail.MovieInfoResult.MovieInfo?) {
    textView.textSize = 14f
    textView.text = item?.genres?.map { it.genreNm }?.joinToString(", ")
}

@BindingAdapter("rankDetailOpenDt")
fun setRankDetailOpenDt(textView: android.widget.TextView, item: RankDetail.MovieInfoResult.MovieInfo?) {
    textView.textSize = 15f
    textView.text = item?.openDt
}

@BindingAdapter("rankDetailActors")
fun setRankDtailActors(textView: android.widget.TextView, item: RankDetail.MovieInfoResult.MovieInfo?) {
    textView.textSize = 14f
    textView.text = item?.actors?.map { "${it.peopleNm}-(${it.cast}역)" }?.joinToString(", ")
}

