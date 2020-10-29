package com.example.nguphaptienghan.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.nguphaptienghan.R
import com.example.nguphaptienghan.fragments.PracticeFragment
import com.example.nguphaptienghan.fragments.PronounceFragment

class ContentActivity : AppCompatActivity() {
    private lateinit var mFrameContent: FrameLayout
    private lateinit var mToolbar: Toolbar
    private lateinit var mTvTile: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        initView()
        val typeFragment = intent.getIntExtra("name", 0)
        actionToolBar()

        if (typeFragment == 1) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_content, PracticeFragment.newInstance()).commit()
            mTvTile.text = getString(R.string.flash_card)
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_content, PronounceFragment.newInstance()).commit()
            mTvTile.text = getString(R.string.menu_exam)
        }

    }

    // init View in Layout
    private fun initView() {
        mFrameContent = findViewById(R.id.frame_content)
        mToolbar = findViewById(R.id.toolbar)
        mTvTile = findViewById(R.id.tv_Title_home)
    }

    private fun actionToolBar() {
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mToolbar.setNavigationIcon(R.drawable.ic_left1)
        mToolbar.setNavigationOnClickListener{
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}


