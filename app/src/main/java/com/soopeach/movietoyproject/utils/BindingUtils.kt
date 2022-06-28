package com.soopeach.movietoyproject.utils

import androidx.databinding.BindingAdapter
import com.soopeach.movietoyproject.adapters.RankListAdapter
import com.soopeach.movietoyproject.models.RankList

class BindingUtils {
}

@BindingAdapter("hintForDate")
fun setHintForDate(editText: android.widget.EditText, hint: String) {
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