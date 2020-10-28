package com.example.nguphaptienghan.activitys

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toolbar
import android.widget.VideoView
import com.example.nguphaptienghan.R
import com.example.nguphaptienghan.fragments.PracticeFragment
import com.example.nguphaptienghan.fragments.PronounceFragment

class ContentActivity : AppCompatActivity() {
    private lateinit var mFrameContent: FrameLayout
    private lateinit var mToolbar: Toolbar
    private lateinit var mTvTile: TextView
    private lateinit var video: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        initView()
        val typeFragment = intent.getIntExtra("name", 0)

        if (typeFragment == 1) {
            supportFragmentManager.beginTransaction().replace(R.id.frame_content, PracticeFragment.newInstance()).commit()
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.frame_content, PronounceFragment.newInstance()).commit()
        }

    }

    // init View in Layout
    private fun initView() {
        mFrameContent = findViewById(R.id.frame_content)
        //mToolbar = findViewById(R.id.toolbar)
        mTvTile = findViewById(R.id.tv_Title_home)
    }
}


