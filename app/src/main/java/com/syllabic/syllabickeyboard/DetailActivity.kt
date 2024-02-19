package com.syllabic.syllabickeyboard

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        window?.decorView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
//        window.statusBarColor = Color.TRANSPARENT
        setContentView(R.layout.activity_detail)
        imgBack.setOnClickListener {
            finish()
        }
        tvBack.setOnClickListener {
            finish()
        }

    }

}