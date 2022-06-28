package com.soopeach.movietoyproject.utils

import androidx.databinding.BindingAdapter

class BindingUtils {
}

@BindingAdapter("hintForDate")
fun setHintForDate(editText: android.widget.EditText, hint: String) {
    editText.hint = "검색 예시 ex) " + hint
}