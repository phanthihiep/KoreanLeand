package com.example.nguphaptienghan.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toolbar
import com.example.nguphaptienghan.R

class ContentActivity : AppCompatActivity() {
    private lateinit var mFrameContent: FrameLayout
    private lateinit var mToolbar: Toolbar
    private lateinit var mTvTile: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        val typeFragment = intent.getIntExtra("name", 0)
        initView()
    }

    // init View in Layout
    private fun initView() {
        mFrameContent = findViewById(R.id.frame_content)
        mToolbar = findViewById(R.id.toolbar)
        mTvTile = findViewById(R.id.tv_Title_home)
    }
}