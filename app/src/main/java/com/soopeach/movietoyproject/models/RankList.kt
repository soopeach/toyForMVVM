package com.soopeach.movietoyproject.models

data class RankList(
    val boxOfficeResult: BoxOfficeResult
) {
    data class BoxOfficeResult(
        val boxofficeType: String,
        val dailyBoxOfficeList: List<DailyBoxOffice>,
        val showRange: String
    ) {
        data class DailyBoxOffice(
            val audiAcc: String,
            val audiChange: String,
            val audiCnt: String,
            val audiInten: String,
            val movieCd: String,
            val movieNm: String,
            val openDt: String,
            val rank: String,
            val rankInten: String,
            val rankOldAndNew: String,
            val rnum: String,
            val salesAcc: String,
            val salesAmt: String,
            val salesChange: String,
            val salesInten: String,
            val salesShare: String,
            val scrnCnt: String,
            val showCnt: String
        )
    }
}



fun RankList.getRankList(): List<RankList.BoxOfficeResult.DailyBoxOffice> {
    return boxOfficeResult.dailyBoxOfficeList
}
