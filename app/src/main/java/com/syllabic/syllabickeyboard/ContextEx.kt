package com.syllabic.syllabickeyboard

import android.content.Context
import android.content.SharedPreferences


fun Context.getSharedPrefs(): SharedPreferences =
    getSharedPreferences("Prefs", Context.MODE_PRIVATE)


